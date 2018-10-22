package com.zheng.service;

import com.zheng.entity.DictionaryEntity;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-19.
 */
public interface PubService {
    /**
     * 根据keyNo查询字典
     * @param keyno
     * @return
     */
    List<DictionaryEntity>  selectDictByKeyNo(Integer keyno);


    /**
     * 获取新的客户编号
     * @return
     */
    String  creatNewCustNO();

    /**
     * 获取新的交易编号
     * @return
     */
    String  creatNewTradeAccoNo();

    /**
     * 获取新的基金编号
     * @return
     */
    String  creatNewFundAccoNo();

    public void  checkIsStartTrade(Integer trustTypeCode);
}
