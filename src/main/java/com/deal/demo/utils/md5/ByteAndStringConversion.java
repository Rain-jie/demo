package com.deal.demo.utils.md5;

/**
 * @version V1.0
 * @Title: ByteAndStringConversion.java <br>
 * @Package com.jxp.utils.md5 <br>
 * @Description: (byte[]和string互转) <br>
 * @author: 路逸冰(Allen) <br>
 * @date: 2019/11/26 00:01 <br>
 */
public class ByteAndStringConversion {

    /**
     * 将16进制字符串转换成字节数组
     *
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) ("0123456789ABCDEF".indexOf(hexChars[pos]) << 4
                    | "0123456789ABCDEF".indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    /**
     * 将指定byte数组转换成16进制字符串
     *
     * @param b
     * @return
     */
    public static String byteToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length);
        String sTemp;
        for (int i = 0; i < b.length; i++) {
            sTemp = Integer.toHexString(0xFF & b[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}
