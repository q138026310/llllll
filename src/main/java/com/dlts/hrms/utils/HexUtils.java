package com.dlts.hrms.utils;

public class HexUtils {

    private HexUtils(){}

    private static final char[] HEX = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] bytes) {

        if (null == bytes) {
            return null;
        }

        StringBuilder sb = new StringBuilder(bytes.length << 1);

        for (int i = 0; i < bytes.length; ++i) {
            sb.append(HEX[(bytes[i] & 0xf0) >> 4]).append(HEX[(bytes[i] & 0x0f)]);
        }

        return sb.toString();
    }

}
