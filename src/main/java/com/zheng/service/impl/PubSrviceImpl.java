package com.zheng.service.impl;

import com.zheng.entity.DictionaryEntity;
import com.zheng.mapper.DictionaryMapper;
import com.zheng.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-19.
 */
@Service
public class PubSrviceImpl  implements PubService {


    @Autowired
    DictionaryMapper  dictionaryMapper;

    @Override
    public List<DictionaryEntity> selectDictByKeyNo(Integer keyno) {
        return dictionaryMapper.selectDictionaryByKey(keyno);
    }
}
