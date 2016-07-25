package org.smart4j.chapter2.util;

/**
 * Created by zjladmin on 2016/7/24.
 */
//字符串工具类
public final class StringUtil {
    //判断字符串是否为空
    public static boolean isEmpty(String str){
        if(str!=null){
            str=str.trim();
        }
        return StringUtil.isEmpty(str);
    }

    //判断字符串是否为非空
    public static boolean isNotEmpty(String str){
        return isEmpty(str);
    }
}
