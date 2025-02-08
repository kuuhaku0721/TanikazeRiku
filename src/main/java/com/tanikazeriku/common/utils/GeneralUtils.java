package com.tanikazeriku.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用工具类
 */
public class GeneralUtils {

    /**
     * Entity 转 DTO
     * Entity包含image字段，DTO不需要这个，image在General下单独传输
     * @param entity 数据实体
     * @param dtoClass 数据传输对象
     * @return 转换完毕的数据传输对象
     * @param <E> 数据实体模板
     * @param <D> 数据传输对象模板
     */
    public static <E, D> D convertEntityToDTO(E entity, Class<D> dtoClass) {
        if(entity == null) {
            return null;
        }
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            Field[] entityFields = entity.getClass().getDeclaredFields();
            for(Field entityField: entityFields) {
                if(entityField.getType() != byte[].class) {
                    entityField.setAccessible(true);
                    Object value = entityField.get(entity);
                    // String dtoFieldName = toCamelCase(entityField.getName());
                    try {
                        Field dtoField = dtoClass.getDeclaredField(entityField.getName());
                        dtoField.setAccessible(true);
                        dtoField.set(dto, value);
                    } catch (NoSuchFieldException e) {
                        // 没有这个字段直接忽略，无需抛异常
                    }
                }
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Entity to DTO failed! please check all funcs");
        }
    }

    /**
     * 列表转换
     * @param entities 将要被转换的数据实体列表
     * @param dtoClass 目标对象类
     * @return 数据传输对象列表
     * @param <E> 数据实体模板
     * @param <D> 数据传输对象模板
     */
    public static <E, D> List<D> convertWithList(List<E> entities, Class<D> dtoClass) {
        List<D> dtoList = new ArrayList<>();
        if(entities != null) {
            for(E entity : entities) {
                D dto = convertEntityToDTO(entity, dtoClass);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    /**
     * 带_字符串转换成驼峰命名法字符串
     * @param str 原始带_字符串
     * @return 驼峰命名法字符串
     */
    private static String toCamelCase(String str) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;
        for(char c : str.toCharArray()) {
            if(c == '_') {
                capitalizeNext = true;
            } else {
                if(capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
