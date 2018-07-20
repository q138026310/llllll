package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.App;
import com.dlts.hrms.domain.cm.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    static Logger logger = LoggerFactory.getLogger(Md5Utils.class);

    private Md5Utils(){}

    private static MessageDigest MD;
    private static Charset UTF_8;

    static {
        UTF_8 = Charset.forName(App.Encode.UTF_8);
        try {
            MD = MessageDigest.getInstance(App.encrypt.MD5);
        } catch (NoSuchAlgorithmException e) {
            logger.error("content",e);
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(Long value) {
        byte[] bytes = MD.digest((value + SecretKey.VALUE).getBytes(UTF_8));
        return HexUtils.toHexString(bytes);
    }

    public static String encrypt(String value) {
        byte[] bytes = MD.digest((value + SecretKey.VALUE).getBytes(UTF_8));
        return HexUtils.toHexString(bytes);
    }

}
