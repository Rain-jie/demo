package com.deal.demo.utils.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version V1.0
 * @Title: Md5SaltUtil.java <br>
 * @Package com.jxp.utils.md5 <br>
 * @Description: (MD5盐值加密) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2019/11/26 00:02 <br>
 */
public class Md5SaltUtil {

    /**
     * md5盐值
     */
    private static final String SALT = "201911yay";

    /**
     * md5+salt加密，salt存储到数据库中
     * @param passWord
     * @return
     */
    public static String encodeMd5Salt(String passWord) {
        try {
            //将密码转换成字节
            byte[] bPwd = passWord.getBytes("UTF-8");
            byte[] salt = ByteAndStringConversion.hexStringToByte(SALT);
            //创建byte字节数组，长度为salt长度+密码转换字节后的长度
            byte[] newPwd = new byte[bPwd.length + salt.length];
            //将密码字节数组与salt数组合并，组合方式：salt在前，密码数组在后
            System.arraycopy(salt, 0, newPwd, 0, salt.length);
            System.arraycopy(bPwd, 0, newPwd, salt.length, bPwd.length);
            //创建信息摘要指定为MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //将newPwd进行加密
            md5.update(newPwd);
            //获取加密后的内容
            byte[] md5Pwd = md5.digest();
            //从字节数组转为字符串
            String strSalt = ByteAndStringConversion.byteToHexString(md5Pwd);
            //将加密后的内容转换成16进制字符串,返回(MD5[盐值+密码]) + 盐值
            return strSalt;
        } catch (UnsupportedEncodingException e) {
            return e.toString();
        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}