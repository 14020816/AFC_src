package com.company;

public class Card extends Certificate {
    public static final float BASE_FARE = (float) 1.9;
    public  float balance;
    public  int lastStaion;
    public  Card(String ID, float balance){
        super(ID);
        this.type = TYPE.CADR;
        this.balance = balance;
        this.lastStaion = -1;
    }

    public void charge(float money){
        this.balance += money;
    }

}
