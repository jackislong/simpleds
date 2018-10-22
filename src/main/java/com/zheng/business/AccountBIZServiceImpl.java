package com.zheng.business;

import com.zheng.entity.CustInfoEntity;
import com.zheng.entity.TradeAccoInfoEntity;
import com.zheng.exception.SimpleBusException;
import com.zheng.service.AccountService;
import com.zheng.service.PubService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.CaseInsensitiveMap;
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

        CustInfoEntity cust =  new CustInfoEntity();
        cust.setCustno(pubService.creatNewCustNO());
        BeanUtils.copyProperties(map,cust);

        TradeAccoInfoEntity  tradeAcco = new TradeAccoInfoEntity();
        tradeAcco.setTradeacco(pubService.creatNewTradeAccoNo());
        BeanUtils.copyProperties(map,tradeAcco);
        return null;
    }


}
