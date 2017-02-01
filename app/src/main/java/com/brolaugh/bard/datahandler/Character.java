package com.brolaugh.bard.datahandler;


import android.util.Log;

import com.brolaugh.bard.SQLiteConnection;


public class Character {
    private int id;
    private String name;
    private String race;
    private String classType;
    private String background;
    private String alignment;

    private byte strength;
    private byte dexterity;
    private byte constitution;
    private byte intelligence;
    private byte wisdom;
    private byte charisma;

    public Character(
            String name,
            String race,
            String classType,
            String background,
            String alignment,
            byte strength,
            byte dexterity,
            byte constitution,
            byte intelligence,
            byte wisdom,
            byte charisma
    ) {
        this.name = name;
        this.race = race;
        this.classType = classType;
        this.alignment = alignment;
        this.background = background;

        this.charisma = charisma;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.strength = strength;
        this.wisdom = wisdom;
    }

    public Character(
            int id,
            String name,
            String race,
            String background,
            String alignment,
            String classType,
            byte strength,
            byte dexterity,
            byte constitution,
            byte intelligence,
            byte wisdom,
            byte charisma
    ) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.classType = classType;
        this.background = background;
        this.alignment = alignment;

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public void save(){
        Log.d("Character", "Name: "+ this.name + " race" + this.race);
        SQLiteConnection.insertCharacter(this);
    }

    public byte getConstitution() {
        return constitution;
    }

    public String getAlignment() {
        return alignment;
    }

    public String getBackground() {
        return background;
    }

    public byte getCharisma() {
        return charisma;
    }

    public byte getDexterity() {
        return dexterity;
    }

    public byte getIntelligence() {
        return intelligence;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public byte getStrength() {
        return strength;
    }

    public byte getWisdom() {
        return wisdom;
    }

    public int getId() {
        return id;
    }

    public String getClassType() {
        return classType;
    }
}
