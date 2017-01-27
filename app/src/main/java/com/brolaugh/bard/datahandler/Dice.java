package com.brolaugh.bard.datahandler;

import java.util.Random;

public class Dice {
    public static final int[] AVAILABLE_DICE = {4,6,8,10,12,20};
    private short maxRoll;
    private short numberOfDice;

    public Dice(String diceString){
        String mRoll = diceString.split("D")[1];
        String nrDice = diceString.split("D")[0];

        maxRoll  = (short) (Short.parseShort(mRoll));
        numberOfDice = Short.valueOf(nrDice);
    }
    public short roll(){
        Random random = new Random();
        return (short)(random.nextInt(maxRoll)+1);
    }
    public short rollWithAdvantage(){
        short highestRoll = 0;
        Random random = new Random();
        for(short i = 0; i < numberOfDice;i++){
            short currentRoll =(short) (random.nextInt(maxRoll) + 1 );
            if(currentRoll > highestRoll){
                highestRoll = currentRoll;
            }
        }
        return highestRoll;
    }
    public short rollWithDisAdvantage(){
        short lowestRoll = 0;
        Random random = new Random();
        for(short i = 0; i < numberOfDice;i++){
            short currentRoll =(short) (random.nextInt(maxRoll) +1 );
            if(currentRoll < lowestRoll){
                lowestRoll = currentRoll;
            }
        }
        return lowestRoll;
    }
}
