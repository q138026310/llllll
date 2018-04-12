package com.dlts.hrms.utils;

public class HexUtils {

    private static final char[] hex = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] bytes) {

        if (null == bytes) {
            return null;
        }

        StringBuilder sb = new StringBuilder(bytes.length << 1);

        for (int i = 0; i < bytes.length; ++i) {
            sb.append(hex[(bytes[i] & 0xf0) >> 4]).append(hex[(bytes[i] & 0x0f)]);
        }

        return sb.toString();
    }

}