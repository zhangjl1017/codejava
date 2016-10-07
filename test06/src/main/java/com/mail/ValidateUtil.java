package com.mail;

/**
 * Created by zjladmin on 2016/9/21.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式验证输入格式
 * @author liuxing
 *
 */
public class ValidateUtil {
    public static void main(String[] args) {
        System.out.println(checkEmail("14_8@qw.df"));
        System.out.println(checkMobileNumber("071-3534452"));
        System.out.println(checkMobileNumber("18717757735"));
    }
    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证IP地址
     * @param IP
     * @return
     */
    public static boolean checkIPAddress(String ipAddress){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
            Matcher matcher = regex.matcher(ipAddress);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证日期
     * @param date
     * @return
     */
    public static boolean checkDate(String date){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^((\\\\d{2}(([02468][048])|([13579][26]))[\\\\-\\\\/\\\\s]?((((0?[13578])|(1[02]))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])))))|(\\\\d{2}(([02468][1235679])|([13579][01345789]))[\\\\-\\\\/\\\\s]?((((0?[13578])|(1[02]))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\\\-\\\\/\\\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\\\-\\\\/\\\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\\\s(((0?[0-9])|([1-2][0-3]))\\\\:([0-5]?[0-9])((\\\\s)|(\\\\:([0-5]?[0-9])))))?$");
            Matcher matcher = regex.matcher(date);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }


}