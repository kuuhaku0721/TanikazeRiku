package com.tanikazeriku.common.utils;

import com.tanikazeriku.pojo.Entity.UserWrapper;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
     * 字符串转User包装类
     * @param str 服务器接收到的字符串
     * @return UserWrapper包装类
     */
    public static UserWrapper convertToUserWrapper(String str) {
        UserWrapper user = new UserWrapper();
        String[] values = str.split("&");
        for(String pair : values) {
            String[] parts = pair.split("=");
            if(parts.length == 2) {
                String key = parts[0];
                String value = parts[1];
                switch (key) {
                    case "username":
                        user.setUsername(value);
                    case "password":
                        user.setPassword(value);
                }
            }
        }
        return user;
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

    /**
     * 生成指定长度的随机字符串
     * @param length 要生成的随机字符串的长度
     * @return 生成的随机字符串
     */
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    /**
     * 将形如 "A:XXX;B:XXX;C:XXX;D:XXX;" 的字符串转换为 KeyValuePair 对象数组
     * @param input 输入的字符串
     * @return KeyValuePair 对象数组
     */
    public static List<KVPair> parseStringToKeyValuePair(String input) {
        String[] pairs = input.split(";");
        List<KVPair> pairList = new ArrayList<>();
        for (String pair : pairs) {
            if (!pair.isEmpty()) {
                String[] keyValue = pair.split(":", 2);
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    pairList.add(new KVPair(key, value));
                }
            }
        }
        return pairList;
    }

    /**
     * 对输入的明文字符串进行 MD5 加密
     * @param plainText 明文字符串
     * @return 加密后的十六进制字符串，如果加密过程出错则返回 null
     */
    public static String md5Encrypt(String plainText) {
        try {
            // 获取 MD5 算法的 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将明文字符串转换为字节数组并进行加密
            byte[] digest = md.digest(plainText.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
