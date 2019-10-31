package com.company;

import java.util.List;

public class OnewayTicket extends Ticket {

    private  char enterStaion;
    private  char exitStation;
    private  float balance;

    public  OnewayTicket(String ID, char enterStaion, char exitStation, float balance){
        this.ID  = ID;
        this.enterStaion = enterStaion;
        this.exitStation = exitStation;
        this.balance = balance;
        this.status = STATUS.NEW;
    }

    @Override
    public boolean validateEnter(char enterStaion) {
        if(status != STATUS.NEW){
            this.error = "Ticket is used";
            return  false;
        }
        if((int)enterStaion >= (int)this.enterStaion && (int)enterStaion <= (int)this.exitStation){
            this.status = STATUS.INTRAVEL;
            return  true;
        }
        this.error = "Out of station range";
        return  false;
    }

    @Override
    public boolean validateExit(float distance) {
        if(balance >= FareCaculator.fareCaculate(distance)){
            this.status = STATUS.USED;
            return true;
        }
        this.error = "Invalid ticket";
        return false;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Type: One way ticket: " );
    }
}
