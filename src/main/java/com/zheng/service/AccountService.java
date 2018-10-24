package com.zheng.service;

import com.zheng.bean.DateTimeBean;
import com.zheng.entity.*;

/**
 * AccountAPI
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public interface AccountService {


    /**
     * 创建委托
     * @param custInfo
     * @param fundAccoInfo
     * @param tradeAccoInfo
     * @param dateTimeBean
     * @return
     */

      AccoTrustEntity   buileAccoTrust(CustInfoEntity  custInfo, FundAccoInfoEntity  fundAccoInfo, TradeAccoInfoEntity  tradeAccoInfo, DateTimeBean  dateTimeBean);

    /**
     * 根据证件类型和证件号码查询客户
     * @param certType
     * @param certNo
     * @return
     */
    CustInfoEntity  selectCustInfoByCertTypeAndCertNo(String  certType,String certNo);

    /**
     * 检查证件号码是否合规
     * @return
     */
    public Boolean  checkIsIDNo(String  identityNo);

    /**
     * 根据ta代码和客户编码获取基金账户
     * @param tradeacco
     * @param taCode
     * @return
     */
    public FundAccoInfoEntity selectFundAccoInfoByTradeAccoAndTACode(String tradeacco,String taCode);

    /**
     * 保存客户实体
     * @param custInfoEntity
     * @return
     */
    int  saveCustInfo(CustInfoEntity  custInfoEntity);

    /**
     * 保存基金账户
     * @return
     */
    int  saveFundAccoInfo(FundAccoInfoEntity  fundAccoInfoEntity);

    /**
     * 保存交易账户
     * @param tradeAccoInfoEntity
     * @return
     */
    int  saveTradeAccoInfo(TradeAccoInfoEntity  tradeAccoInfoEntity);

    /**
     * 保存账户关联关系
     * @param accorelaInfoEntity
     * @return
     */
    int  saveAccoRealtion(AccorelaInfoEntity  accorelaInfoEntity);

    /**
     * 保存银行账户信息
     * @param bankInfoEntity
     * @return
     */
    int  saveBankInfo(AccountBankInfoEntity  bankInfoEntity);


    /**
     * 保存客户密码
     * @param passWordEntity
     * @return
     */
    int  saveCustPassWord(CustPassWordEntity  passWordEntity);


    /**
     * 保存个人信息
     * @param custPersonEntity
     * @return
     */
    int  saveCustPerson(CustPersonEntity  custPersonEntity);

    /**
     * 保存委托信息
     * @param accoTrustEntity
     * @return
     */
    int  saveAccoTrust(AccoTrustEntity accoTrustEntity);

    /**
     * 保存银行绑定信息
     * @param accountBankBindEntity
     * @return
     */
    int  saveAccountBankBind(AccountBankBindEntity  accountBankBindEntity);
}
