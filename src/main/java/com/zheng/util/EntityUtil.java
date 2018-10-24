package com.zheng.util;

import lombok.extern.slf4j.Slf4j;
import sun.util.resources.cldr.ga.LocaleNames_ga;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
@Slf4j
public class EntityUtil<T> {

    /**
     * Map转成实体对象
     * @param map map实体对象包含属性
     * @param clazz 实体对象类型
     * @return
     */
    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            log.error("实体转换错误:",e);
        }
        return obj;
    }

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);

            if(value instanceof Long){
                map.put(fieldName, value==null?"":value.toString());
            }else{
                map.put(fieldName, value);
            }
            } catch (IllegalAccessException e) {
                log.error("转换出错",e);
            }
        }
        return map;
    }

}
