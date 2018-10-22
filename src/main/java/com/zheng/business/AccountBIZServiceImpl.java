package com.zheng.business;

import com.zheng.entity.*;
import com.zheng.exception.SimpleBusException;
import com.zheng.service.AccountService;
import com.zheng.service.PubService;
import com.zheng.util.EntityUtil;
import com.zheng.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Map openaccount(CaseInsensitiveMap map) {
        String trustType = MapUtils.getString(map,"trustType");
        String certType = MapUtils.getString(map,"certType");
        String certNo = MapUtils.getString(map,"certNo");
        /**
         * 检查柜台是否停柜
         */
        log.info("检查是否停柜");
        pubService.checkIsStartTrade(new Integer(trustType));

        CustInfoEntity  custInfo  =  accountService.selectCustInfoByCertTypeAndCertNo(certType,certNo);
        if(custInfo != null){
            throw  new SimpleBusException("客户已存在");
        }

        log.info("创建客户");
        CustInfoEntity cust = (CustInfoEntity) EntityUtil.map2Object(map,CustInfoEntity.class);
        cust.setCustno(pubService.creatNewCustNO());
        accountService.saveCustInfo(cust);

        /**
         * 创建交易账号
         */
        TradeAccoInfoEntity  tradeAcco = (TradeAccoInfoEntity) EntityUtil.map2Object(map,TradeAccoInfoEntity.class);
        tradeAcco.setTradeacco(pubService.creatNewTradeAccoNo());
        tradeAcco.setCustno(cust.getCustno());


        /**
         * 创建基金账户
         */
        FundAccoInfoEntity  fundAccoInfo = (FundAccoInfoEntity) EntityUtil.map2Object(map,FundAccoInfoEntity.class);
        fundAccoInfo.setCustno(cust.getCustno());

        /**
         * 创建个人账户
         */
        CustPersonEntity custPersonEntity = (CustPersonEntity) EntityUtil.map2Object(map,CustPersonEntity.class);
        custPersonEntity.setCustno(cust.getCustno());

        /**
         * 创建密码
         */
        CustPassWordEntity  custPassWordEntity = (CustPassWordEntity) EntityUtil.map2Object(map,CustPassWordEntity.class);
        custPassWordEntity.setCustno(cust.getCustno());
        custPassWordEntity.setDealpassword(Md5Util.MD5(MapUtils.getString(map,"password")));

        AccountBankInfoEntity accountBankInfoEntity = (AccountBankInfoEntity)EntityUtil.map2Object(map,AccountBankInfoEntity.class);
        accountBankInfoEntity.setCustno(cust.getCustno());
        AccorelaInfoEntity accorelaInfoEntity = (AccorelaInfoEntity) EntityUtil.map2Object(map,AccorelaInfoEntity.class);
        accorelaInfoEntity.setCustno(cust.getCustno());
        accorelaInfoEntity.setFundacco(fundAccoInfo.getFundacco());
        accorelaInfoEntity.setTradeacco(tradeAcco.getTradeacco());
        return null;
    }


}
