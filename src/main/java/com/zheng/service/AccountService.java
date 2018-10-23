package com.zheng.service;

import com.zheng.entity.CustInfoEntity;
import com.zheng.entity.FundAccoInfoEntity;

/**
 * AccountAPI
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public interface AccountService {
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
}
