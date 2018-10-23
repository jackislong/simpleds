package com.zheng.service.impl;

import com.zheng.bean.DateTimeBean;
import com.zheng.entity.*;
import com.zheng.mapper.*;
import com.zheng.service.AccountService;
import com.zheng.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    CustInfoEntityMapper  custInfoEntityMapper;

    @Autowired
    FundAccoInfoEntityMapper  fundAccoInfoEntityMapper;

    @Autowired
    AccountBankInfoEntityMapper  bankInfoEntityMapper;


    @Autowired
    AccorelaInfoEntityMapper  accorelaInfoEntityMapper;


    @Autowired
    CustPassWordEntityMapper  custPassWordEntityMapper;

    @Autowired
    TradeAccoInfoEntityMapper  tradeAccoInfoEntityMapper;


    @Autowired
    CustPersonEntityMapper   custPersonEntityMapper;

    @Autowired
    AccoTrustEntityMapper  accoTrustEntityMapper;

    @Autowired
    PubService  pubService;

    @Override
    public AccoTrustEntity buileAccoTrust(CustInfoEntity custInfo, FundAccoInfoEntity fundAccoInfo, TradeAccoInfoEntity tradeAccoInfo, DateTimeBean dateTimeBean) {
        AccoTrustEntity  accoTrust = new AccoTrustEntity();
        accoTrust.setTrustrequestno(pubService.creatNewAccoTrustRquestNo());
        accoTrust.setTacode(fundAccoInfo.getTacode());
        accoTrust.setCusttype(custInfo.getCusttype());
        accoTrust.setCustno(custInfo.getCustno());
        accoTrust.setIdentitytype(custInfo.getIdentitytype());
        accoTrust.setIdentityno(custInfo.getIdentityno());
        accoTrust.setFundacco(fundAccoInfo.getFundacco());
        accoTrust.setTradeacco(tradeAccoInfo.getTradeacco());
        accoTrust.setRequestdate(dateTimeBean.getTradeDate());
        accoTrust.setRequesttime(dateTimeBean.getTradeTime());
        accoTrust.setCustomname(custInfo.getCustomname());
        return accoTrust;
    }

    @Override
    public CustInfoEntity selectCustInfoByCertTypeAndCertNo(String certType, String certNo) {
        Map parMap = new HashMap();
        parMap.put("certType",certType);
        parMap.put("certNo",certNo);
         List<CustInfoEntity> resultList=custInfoEntityMapper.selectCustInfoByCertTypeAndCertNo(parMap);
        if(resultList!= null && !resultList.isEmpty()){
           return   resultList.get(0);
        }
        return null;
    }

    @Override
    public Boolean checkIsIDNo(String  identityNo) {
    // 1 是否是18为身份证号
    if ( identityNo.length() != 18 )
    {
        return false;
    }

    // 2 将身份证号码前面的17位数分别乘以不同的系数
    // 从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
    final int list_17[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    int nflag = 0, rflag;
    String tflag;

    // 3 将这17位数字和系数相乘的结果相加
    int length = identityNo.length() - 1;
    int[] n = new int[length];
    for ( int i = 0; i < length; i++ )
    {
        // 3.1 检查是否前17位全数字
        try
        {
            n[ i ] = Integer.parseInt( identityNo.substring( i, i + 1 ) );
        } catch ( NumberFormatException nfe )
        {
            return false;
        }

        // 3.2 将这17位数字和系数相乘的结果相加
        nflag += n[ i ] * list_17[ i ];
    }

    // 4 用加出来和除以11求余数求出校验位
    rflag = nflag % 11;
    if ( rflag == 0 )
    {
        tflag = "1";
    }
    else if ( rflag == 1 )
    {
        tflag = "0";
    }
    else if ( rflag == 2 )
    {
        tflag = "X";
    }
    else
    {
        tflag = String.valueOf( 12 - rflag );
    }

    // 5 获得校验位是否合法
    return tflag.equalsIgnoreCase( identityNo.substring( 17 ) );
    }


    @Override
    public FundAccoInfoEntity selectFundAccoInfoByTradeAccoAndTACode(String tradeAcco, String taCode) {
        Map  parMap = new HashMap();
        parMap.put("tradeacco",tradeAcco);
        parMap.put("tacode",taCode);
        List<FundAccoInfoEntity> fundAccoList = fundAccoInfoEntityMapper.selectFundAccoInfoByTradeAccoAndTaCode((HashMap) parMap);
        if(fundAccoList!= null  && !fundAccoList.isEmpty()){
            return fundAccoList.get(0);
        }
        return null;
    }

    @Override
    public int saveCustInfo(CustInfoEntity custInfoEntity) {
        custInfoEntity.setVersion(0);
        custInfoEntity.setCreatetimestamp(new Date());
        custInfoEntity.setUpdatetimestamp(new Date());
        return custInfoEntityMapper.insert(custInfoEntity);
    }

    @Override
    public int saveFundAccoInfo(FundAccoInfoEntity fundAccoInfoEntity) {
        fundAccoInfoEntity.setVersion(0);
        fundAccoInfoEntity.setCreatetimestamp(new Date());
        fundAccoInfoEntity.setUpdatetimestamp(new Date());
        return fundAccoInfoEntityMapper.insert(fundAccoInfoEntity);
    }

    @Override
    public int saveTradeAccoInfo(TradeAccoInfoEntity tradeAccoInfoEntity) {
        tradeAccoInfoEntity.setVersion(0);
        tradeAccoInfoEntity.setCreatetimestamp(new Date());
        tradeAccoInfoEntity.setUpdatetimestamp(new Date());
        return tradeAccoInfoEntityMapper.insert(tradeAccoInfoEntity);
    }

    @Override
    public int saveAccoRealtion(AccorelaInfoEntity accorelaInfoEntity) {
        accorelaInfoEntity.setVersion(0);
        accorelaInfoEntity.setCreatetimestamp(new Date());
        accorelaInfoEntity.setUpdatetimestamp(new Date());
        return accorelaInfoEntityMapper.insert(accorelaInfoEntity);
    }

    @Override
    public int saveBankInfo(AccountBankInfoEntity bankInfoEntity) {
        bankInfoEntity.setVersion(0);
        bankInfoEntity.setCreatetimestamp(new Date());
        bankInfoEntity.setUpdatetimestamp(new Date());
        return bankInfoEntityMapper.insert(bankInfoEntity);
    }

    @Override
    public int saveCustPassWord(CustPassWordEntity passWordEntity) {
        passWordEntity.setVersion(0);
        passWordEntity.setCreatetimestamp(new Date());
        passWordEntity.setUpdatetimestamp(new Date());
        return custPassWordEntityMapper.insert(passWordEntity);
    }

    @Override
    public int saveCustPerson(CustPersonEntity custPersonEntity) {
        custPersonEntity.setVersion(0);
        custPersonEntity.setCreatetimestamp(new Date());
        custPersonEntity.setUpdatetimestamp(new Date());
        return custPersonEntityMapper.insert(custPersonEntity);
    }

    @Override
    public int saveAccoTrust(AccoTrustEntity accoTrustEntity) {
        accoTrustEntity.setVersion(0);
        accoTrustEntity.setCreatetimestamp(new Date());
        accoTrustEntity.setUpdatetimestamp(new Date());
        return accoTrustEntityMapper.insert(accoTrustEntity);
    }
}
