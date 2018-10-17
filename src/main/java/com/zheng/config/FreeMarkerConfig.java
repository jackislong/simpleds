package com.zheng.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import com.zheng.tag.SimpleTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-17.
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    protected freemarker.template.Configuration configuration;


    @Autowired
    SimpleTag simpleTag;
    /**
     * 添加自定义标签
     */
    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("simpleTag", simpleTag);
        //shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
