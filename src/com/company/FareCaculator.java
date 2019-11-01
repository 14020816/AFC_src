package com.company;

public class FareCaculator {
    public   static final float BASE_FARE = (float) 1.9;
    public   static final float BASE_DISTANCE = (float) 5;
    public   static final float FARE_INDEX = (float) 0.4;

    public static  float fareCaculate(float distance){
        float fare = BASE_FARE;
        if(distance <= BASE_DISTANCE){
            return  fare;
        }
        float distanceExtend;
        float fareExtend;
        float div = (distance - BASE_DISTANCE)%2;
        if(div != 0) {
        	distanceExtend = (int)((distance - BASE_DISTANCE - div)/2) + 1;
        }else {
        	distanceExtend = (int)((distance - BASE_DISTANCE - div)/2);
        }
        fareExtend = distanceExtend*FARE_INDEX;
        fare += fareExtend;
        return  fare;
    }

}
