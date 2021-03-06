package com.zx.encode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     *
     * @param plainText 明文
     * @return 32位密文
     */
    public static String encryption(String plainText) {
        String re_md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5Util");
            try {
                md.update(plainText.getBytes("Utf-8"));
            } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
            }
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (byte aB : b) {
                i = aB;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

    /**
     *
     * @param originstr 明文
     * @return 32位密文 大写
     */
    public static String encryptionUp(String originstr) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try
        {
            byte[] btInput = originstr.getBytes("UTF-8");

            MessageDigest mdInst = MessageDigest.getInstance("MD5Util");

            mdInst.update(btInput);

            byte[] md = mdInst.digest();

            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }


    public static void main(String[] args){
        String str = "zx";
        System.out.println(MD5Util.encryption(str));
        System.out.println(MD5Util.encryptionUp(str));
    }
}
