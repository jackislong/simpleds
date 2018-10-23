package com.zheng.service.impl;

import com.zheng.entity.CustInfoEntity;
import com.zheng.entity.FundAccoInfoEntity;
import com.zheng.mapper.CustInfoEntityMapper;
import com.zheng.mapper.FundAccoInfoEntityMapper;
import com.zheng.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public CustInfoEntity selectCustInfoByCertTypeAndCertNo(String certType, String certNo) {
        Map parMap = new HashMap();
        parMap.put("certType",certType);
        parMap.put("certNo",certNo);
         List<CustInfoEntity> resultList=custInfoEntityMapper.selectCustInfoByCertTypeAndCertNo(parMap);
        if(resultList!= null && !resultList.isEmpty()){
            resultList.get(0);
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
        return custInfoEntityMapper.insert(custInfoEntity);
    }
}
