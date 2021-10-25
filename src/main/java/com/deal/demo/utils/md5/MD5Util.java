package com.deal.demo.utils.md5;

import java.security.MessageDigest;

public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            } else{
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));}
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    public static String getMD5ofStr(String origString) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(origString.getBytes("UTF-8"));
            byte[] result = md5.digest();
            String origMD5 = byteArray2HexStr(result);
            return origMD5.toLowerCase();
        } catch (Exception e) {
            System.out.println("错误异常       ："+e);
        }
        return null;
    }

    private static String byteArray2HexStr(byte[] bs) {
        StringBuilder md5StrBuff = new StringBuilder();
        for (byte b : bs) {
            if (Integer.toHexString(0xFF & b).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & b));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & b));
            }
        }
        return md5StrBuff.toString();
    }

}
