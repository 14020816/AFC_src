package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TWTicket extends Ticket {

    private  String startTime;

    public  TWTicket(String ID, String startTime){
        this.ID = ID;
        if(startTime == null || startTime.isEmpty()){
            this.status = STATUS.NEW;
        }else{
            this.status = STATUS.INTRAVEL;
            this.startTime = startTime;
        }
    }


    @Override
    public boolean validateEnter(char enterStaion) {
        String currentTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        if(this.status == STATUS.NEW){
            this.status = STATUS.INTRAVEL;
            this.startTime = currentTime;
            return  true;
        }
        String expireTime = new String();
        String day = startTime.substring(8,10);
        String dayPlus = Integer.toString(Integer.parseInt(day) + 1);
        expireTime = startTime.replace(day, dayPlus);
        if(currentTime.compareTo(expireTime) <= 0){
            return  true;
        }
        this.error = "Invalid ticket, time expired";
        return false;
    }

    @Override
    public boolean validateExit(float distance) {
        if(this.status == STATUS.INTRAVEL){
            return  true;
        }
        this.error = "Invalid ticket";
        return  false;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Type: 24H way ticket: " );
    }
}
