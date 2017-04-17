package com.liveneo.etrepair.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.geronimo.mail.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DesBase64Util {
    public static String encrypt(String data) {
        Base64 strs = new Base64();
        try {
            return new String(strs.encode(data.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(decoder.decodeBuffer(s), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 加密
     * @param deskey
     * @return
     */
    public static String encode(String deskey) {
        if (deskey != null && !"".equals(deskey)) {
            BASE64Encoder encoder = new BASE64Encoder();
            String desresult = encoder.encode(DesUtil.encryptMode(deskey.getBytes()));
            return desresult;
        }
        return null;
    }

    /**
     * 解密
     * @param desresult
     * @return
     */
    public static String decoder(String desresult) {
        BASE64Decoder decoder = new BASE64Decoder();
        String result = null;
        try {
            byte[] resGzipXML = decoder.decodeBuffer(desresult);
            result = new String(DesUtil.decryptMode(resGzipXML));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String t1 = encode("ssssss");
        String t2 = decoder(t1);
        System.out.println(t1);
        System.out.println(t2);
    }
}
