package com.dlts.hrms.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.SecretKey;

public class Md5Utils {

    private static MessageDigest MD;
    private static Charset UTF_8;

    static {
        UTF_8 = Charset.forName(GlobalConstant.Encode.UTF_8);
        try {
            MD = MessageDigest.getInstance(GlobalConstant.encrypt.MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(Long value) {
        byte[] bytes = MD.digest((value + SecretKey.value).getBytes(UTF_8));
        return HexUtils.toHexString(bytes);
    }

    public static String encrypt(String value) {
        byte[] bytes = MD.digest((value + SecretKey.value).getBytes(UTF_8));
        return HexUtils.toHexString(bytes);
    }

}
