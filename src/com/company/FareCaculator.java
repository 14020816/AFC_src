package com.company;

public class FareCaculator {
    public   static final float BASE_FARE = (float) 1.9;
    private  static final float FARE_INDEX = 1;
    public static  float fareCaculate(float distance){
        return  distance*FARE_INDEX;
    }

}
