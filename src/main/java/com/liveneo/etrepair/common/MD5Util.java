package com.liveneo.etrepair.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    // 转换字节数组为32位密文
    private static String byteToString(byte[] bByte) {
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < bByte.length; offset++) {
            i = bByte[offset];
            if (i < 0) i += 256;
            if (i < 16) buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        // 转化为大写字母并返回
        return buf.toString();
    }

    /**
     * 获取MD5值
     * @param strObj 要加密的字符串
     * @return
     */
    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
        MD5Util MD5 = new MD5Util();
        String str = "zhoupan";
        System.out.println(MD5.GetMD5Code("111111"));
    }
}
