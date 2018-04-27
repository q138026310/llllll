package com.dlts.hrms.utils;

import java.util.Random;

public class UuidUtils {

    private static final Random RANDOM = new Random();

    private static final int BOUND = 1000000;

    public static Long getUuid() {
        return Long.parseLong(getTime() + getRandom());
        //return UUID.randomUUID().toString();
    }

   private static long getTime(){
        return DateUtils.now().getTime();
   }

   private static String getRandom(){
       return String.format("%06d", RANDOM.nextInt(BOUND));
   }

   public static String getNumber(){
       return DateUtils.formatNumber(DateUtils.now())+getRandom();
   }

}
