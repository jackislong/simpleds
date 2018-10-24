package com.zheng.business;

import com.zheng.bean.DateTimeBean;
import com.zheng.consts.*;
import com.zheng.entity.*;
import com.zheng.exception.SimpleBusException;
import com.zheng.service.AccountService;
import com.zheng.service.PubService;
import com.zheng.service.WorkDayService;
import com.zheng.util.EntityUtil;
import com.zheng.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人开户
 *
 * @author Administrator
 * @date 2018-10-19.
 */
@Service
@Slf4j
public class AccountBIZServiceImpl implements AccountBIZService {

    @Autowired
    PubService  pubService;

    @Autowired
    AccountService  accountService;

    @Autowired
    WorkDayService    workdayService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map openaccount(CaseInsensitiveMap map) {
        Map  resultMap = new HashMap<>();
        String trustType = MapUtils.getString(map,"trustType");
        String certNo = MapUtils.getString(map,"identityno");
        String requestDate = MapUtils.getString(map,"requestDate");
        String requestTime = MapUtils.getString(map,"requestTime");
        String mobileno = MapUtils.getString(map,"moblieno");
        String custType = MapUtils.getString(map,"custtype","0");
        String taCode = MapUtils.getString(map,"taCode","28");
        String custname = MapUtils.getString(map,"custname");
        String identitype = MapUtils.getString(map,"identitype");
        String vocation = MapUtils.getString(map,"vocation");
        String marry = MapUtils.getString(map,"marry");
        String gender = MapUtils.getString(map,"gender");
        map.put("gender",new Integer(gender));
        String businCode = "001";
            /**
             * 检查柜台是否停柜
             */
            log.info("检查是否停柜");
            pubService.checkIsStartTrade(new Integer(trustType));

            CustInfoEntity  custInfo  =  accountService.selectCustInfoByCertTypeAndCertNo(identitype,certNo);
            if(custInfo != null && CustInfoSateEnum.NORMAL.getCode().equals(custInfo.getState())){
                throw  new SimpleBusException("客户已存在");
            }

            log.info("计算交易时间和交易日期");
            DateTimeBean  dateBean = workdayService.getCurrentWorkDate(requestDate,requestTime);


            log.info("检查证件类型");
            if(custType.equals(CustTypeEnum.PERSON.getCode()) && "0".equals(identitype)){
                if(!accountService.checkIsIDNo(certNo)){
                    throw  new  SimpleBusException("证件类型不合法");
                }
                if(!pubService.checkIsAdult(certNo)){
                    throw  new  SimpleBusException("未满18周岁不允许开户");
                }
            }

            log.info("创建客户");
            CustInfoEntity cust = (CustInfoEntity) EntityUtil.map2Object(map,CustInfoEntity.class);
            cust.setCustno(pubService.creatNewCustNO());
            cust.setCustomname(custname);
            cust.setCusttype(custType);
            cust.setState(AccountStateEnum.NORMAL.getCode());
            cust.setIdentitytype(identitype);


            /**
             * 创建交易账号
             */
            log.info("创建交易账号");
            TradeAccoInfoEntity  tradeAcco = (TradeAccoInfoEntity) EntityUtil.map2Object(map,TradeAccoInfoEntity.class);
            tradeAcco.setTradeacco(pubService.creatNewTradeAccoNo());
            tradeAcco.setCustno(cust.getCustno());
            tradeAcco.setAcconame(cust.getCustomname());
            tradeAcco.setState(AccountStateEnum.NORMAL.getCode());
            tradeAcco.setOpendate(dateBean.getTradeDate());


            /**
             * 创建基金账户
             */
            log.info("创建基金账号");
            FundAccoInfoEntity  fundAccoInfo = (FundAccoInfoEntity) EntityUtil.map2Object(map,FundAccoInfoEntity.class);
            fundAccoInfo.setCustno(cust.getCustno());
            fundAccoInfo.setFundacco(pubService.creatNewFundAccoNo());
            fundAccoInfo.setTacode(taCode);
            fundAccoInfo.setOpendate(dateBean.getTradeDate());
            fundAccoInfo.setState(FundAccoStateEnum.NEW.getCode());



            /**
             * 创建个人账户
             */
            log.info("创建个人账户");
            CustPersonEntity custPersonEntity = (CustPersonEntity) EntityUtil.map2Object(map,CustPersonEntity.class);
            custPersonEntity.setCustno(cust.getCustno());
            custPersonEntity.setEducation(vocation);
            custPersonEntity.setMoblieno(mobileno);
            custPersonEntity.setMarriage(marry);

            /**
             * 创建密码
             */
            log.info("创建密码");
            CustPassWordEntity  custPassWordEntity = (CustPassWordEntity) EntityUtil.map2Object(map,CustPassWordEntity.class);
            custPassWordEntity.setCustno(cust.getCustno());
            custPassWordEntity.setDealpassword(Md5Util.MD5(MapUtils.getString(map,"password")));


            log.info("绑定银行信息");
            AccountBankBindEntity  bankBindEntity = (AccountBankBindEntity) EntityUtil.map2Object(map,AccountBankBindEntity.class);
            bankBindEntity.setCustno(cust.getCustno());
            bankBindEntity.setIdcode(pubService.CreatnNewIdCode());
            bankBindEntity.setCapitalmode("1");
            bankBindEntity.setTradeacco(tradeAcco.getTradeacco());


            log.info("创建银行账户");
            AccountBankInfoEntity accountBankInfoEntity = (AccountBankInfoEntity)EntityUtil.map2Object(map,AccountBankInfoEntity.class);
            accountBankInfoEntity.setCustno(cust.getCustno());
            accountBankInfoEntity.setState(AccountStateEnum.NORMAL.getCode());
            accountBankInfoEntity.setIdcode(bankBindEntity.getIdcode());



            log.info("创建账户关联关系");
            AccorelaInfoEntity accorelaInfoEntity = (AccorelaInfoEntity) EntityUtil.map2Object(map,AccorelaInfoEntity.class);
            accorelaInfoEntity.setCustno(cust.getCustno());
            accorelaInfoEntity.setFundacco(fundAccoInfo.getFundacco());
            accorelaInfoEntity.setTradeacco(tradeAcco.getTradeacco());
            accorelaInfoEntity.setTacode(taCode);



            log.info("创建委托交易");
            AccoTrustEntity  accoTrust = accountService.buileAccoTrust(cust,fundAccoInfo,tradeAcco,dateBean);
            accoTrust.setTrusttype(trustType);
            accoTrust.setConfirmflag(AccoConfrimStateEnum.UNCONFRIM.getCode());
            accoTrust.setOperatorno("0");
            accoTrust.setDealflag(DealFlagEnum.UNDEAL.getCode());
            accoTrust.setBusincode(businCode);
            /**
             * 默认柜台资金
             */
            accoTrust.setCapitalmode("1");



            accountService.saveCustInfo(cust);
            accountService.saveFundAccoInfo(fundAccoInfo);
            accountService.saveTradeAccoInfo(tradeAcco);
            accountService.saveBankInfo(accountBankInfoEntity);
            accountService.saveAccoRealtion(accorelaInfoEntity);
            accountService.saveCustPassWord(custPassWordEntity);
            accountService.saveAccoTrust(accoTrust);
            accountService.saveAccountBankBind(bankBindEntity);
            accountService.saveCustPerson(custPersonEntity);
            resultMap.put("success",true);
            resultMap.put("tradeacco",accorelaInfoEntity.getTradeacco());
            resultMap.put("fundacco",accorelaInfoEntity.getFundacco());
            resultMap.put("requestno",accoTrust.getTrustrequestno());
            return resultMap;
    }


}
