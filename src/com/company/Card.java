package com.company;

public abstract class Card extends Certificate {
    public static final float BASE_FARE = (float) 1.9;

    public  Card(String ID){
        super(ID);
    }

    public abstract boolean validateEnter(int enterStation);
    public abstract boolean validateExit(int enterStation);

}
