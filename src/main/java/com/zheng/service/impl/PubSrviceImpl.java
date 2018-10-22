package com.zheng.service.impl;

import com.zheng.consts.FlowStateEnum;
import com.zheng.consts.TrustTypeEnum;
import com.zheng.entity.DictionaryEntity;
import com.zheng.entity.DoprocessEntity;
import com.zheng.exception.SimpleException;
import com.zheng.mapper.DictionaryMapper;
import com.zheng.mapper.DoprocessEntityMapper;
import com.zheng.service.PubService;
import com.zheng.util.DateFromatUtil;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-19.
 */
@Service
public class PubSrviceImpl  implements PubService {


    @Autowired
    JdbcTemplate  template;

    @Autowired
    DictionaryMapper  dictionaryMapper;

    @Autowired
    DoprocessEntityMapper  doprocessEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DictionaryEntity> selectDictByKeyNo(Integer keyno) {
        return dictionaryMapper.selectDictionaryByKey(keyno);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String creatNewCustNO() {
        StringBuilder dateBuild = new StringBuilder(DateFromatUtil.fromatDate(new Date(),DateFromatUtil.YYYYMMDDHHMMSS));
        StringBuilder  custno = new StringBuilder("");
        String  sql = "SELECT NEXTVAL('CUSTNO_SEQUENCE')  as cn";
        List<Map<String, Object>> svList =   template.queryForList(sql);
        String  sequence  = "";
        if(svList!=null && !svList.isEmpty()){
            sequence = MapUtils.getString(((Map)svList.get(0)),"cn");
        }
        Integer  end =6-sequence.length();
        while (custno.length() < end){
               custno.append("0");
        }
        return  dateBuild.append(custno).append(sequence).toString();
    }

    @Override
    public String creatNewTradeAccoNo() {
        StringBuilder dateBuild = new StringBuilder(DateFromatUtil.fromatDate(new Date(),DateFromatUtil.YYYYMMDDHHMMSS));
        StringBuilder  custno = new StringBuilder("");
        String  sql = "SELECT NEXTVAL('TRADEACC_SEQUENCE')  as tn";
        List<Map<String, Object>> svList =   template.queryForList(sql);
        String  sequence  = "";
        if(svList!=null && !svList.isEmpty()){
            sequence = MapUtils.getString(((Map)svList.get(0)),"tn");
        }
        Integer  end =6-sequence.length();
        while (custno.length() < end){
            custno.append("0");
        }
        return  dateBuild.append(custno).append(sequence).toString();
    }

    @Override
    public String creatNewFundAccoNo() {
        StringBuilder dateBuild = new StringBuilder(DateFromatUtil.fromatDate(new Date(),DateFromatUtil.YYYYMMDDHHMMSS));
        StringBuilder  custno = new StringBuilder("");
        String  sql = "SELECT NEXTVAL('FUNDACCO_SEQUENCE')  as fn";
        List<Map<String, Object>> svList =   template.queryForList(sql);
        String  sequence  = "";
        if(svList!=null && !svList.isEmpty()){
            sequence = MapUtils.getString(((Map)svList.get(0)),"fn");
        }
        Integer  end =6-sequence.length();
        while (custno.length() < end){
            custno.append("0");
        }
        return  dateBuild.append(custno).append(sequence).toString();
    }

    @Override
    public void checkIsStartTrade(Integer trustTypeCode) {
        if(TrustTypeEnum.COUNTER.getCode().equals(trustTypeCode) || TrustTypeEnum.FAX.getCode().equals(trustTypeCode)){
            DoprocessEntity  doprocessEntity = doprocessEntityMapper.selectByName("STARTTRADE");
            if(doprocessEntity.getState().equals(FlowStateEnum.END.getCode())){
                throw  new SimpleException("柜台停止交易");
            }
        }
    }
}
