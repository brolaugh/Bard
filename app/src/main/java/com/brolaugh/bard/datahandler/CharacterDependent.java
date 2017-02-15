package com.brolaugh.bard.datahandler;

/**
 * Created by hannes.kindstrommer on 2017-02-07.
 */

public abstract class CharacterDependent {
    private int id;
    private int characterID;

    public int getCharacterId() {
        return characterID;
    }

    public int getId() {
        return id;
    }

    protected void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
