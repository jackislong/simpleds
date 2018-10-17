package com.zheng.tag;

import com.zheng.service.ResourcesService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 自定义标签
 *
 * @author Administrator
 * @date 2018-10-17.
 */
@Component
public class SimpleTag implements TemplateDirectiveModel {

    @Autowired
    ResourcesService resourcesService;

    private static final String METHOD_KEY = "method";
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            Long userId = null;
            if (map.containsKey("key")) {
                String Id = map.get("key").toString();
                if(StringUtils.isEmpty(Id)){
                    return;
                }
                userId = new Long(Id);
            }
            switch (method) {
                case "resourcelist":
                    // 获取列表菜单
                    environment.setVariable("resourcelist", builder.build().wrap(resourcesService.listByUserId(userId)));
                    break;
                default:
                    break;
            }
        }
//        templateDirectiveBody.render(environment.getOut());
    }
}
