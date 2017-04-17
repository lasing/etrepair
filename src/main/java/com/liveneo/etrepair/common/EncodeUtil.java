package com.liveneo.etrepair.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class EncodeUtil {
    private static char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
            sb.append(HEXCHAR[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static byte[] md5(byte[] datas) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(datas);
            return md.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] md5(String datas, String encoding) {
        try {
            return md5(datas.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String requestStr = "caseNO=002123213&userCode=zhoufanshou&reqTM=20160420135612&userKey=123456";
        // String str2 = EncodeUtil.md5(requestStr,"UTF-8").toString();
        String str2 = MD5Util.GetMD5Code(requestStr);
        System.out.println(str2);
        String str = "36ede523efd24c9e7f1db552cac1fb59";
        System.out.println(requestStr);
        System.out.println(str2.equals(str));
    }
}
