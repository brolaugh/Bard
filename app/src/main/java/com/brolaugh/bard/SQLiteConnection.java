package com.brolaugh.bard;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brolaugh.bard.datahandler.Character;

import java.util.ArrayList;

public class SQLiteConnection {
    private static SQLiteDatabase database;
    private static Context context;

    public static void init(Context context) {
        SQLiteConnection.context = context;
    }
    private static SQLiteDatabase getConnection(){
        if(database == null || !database.isOpen()){
            database = context.openOrCreateDatabase("bard.db",context.MODE_PRIVATE,null);
            //database.execSQL("DROP TABLE mix");

            database.execSQL("CREATE TABLE IF NOT EXISTS character("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_name varchar(60),"+
                    " player_name varchar(40),"+
                    " class varchar(20),"+
                    " race varchar(20)," +
                    " level SMALLINT,"+"" +
                    " experience_points INTEGER,"+
                    " background varchar(40),"+
                    " alignment varchar(40),"+
                    " armor_class SMALLINT,"+
                    " initiative TINYINT,"+
                    " max_hit_points SMALLINT,"+
                    " current_hit_points SMALLINT,"+
                    " proficiency_bonus TINYINT,"+
                    " personality_traits varchar(100),"+
                    " ideals varchar(100),"+
                    " bonds varchar(100),"+
                    " flaws varhcar(100),"+
                    " strength TINYINT,"+
                    " dexterity TINYINT,"+
                    " constitution TINYINT,"+
                    " intelligence TINYINT,"+
                    " wisdom TINYINT,"+
                    " charisma TINYINT,"+
                    " languages varchar(100),"+
                    " armor varchar(100),"+
                    " weapon varchar(100),"+
                    " tools varchar(100),"+
                    " hit_dice varchar(10)"+
                    ");");
            database.execSQL("CREATE TABLE IF NOT EXISTS equipment("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_id INTEGER,"+
                    " name varchar(40),"+
                    " amount TINYINT"+
                    ");");
            database.execSQL("CREATE TABLE IF NOT EXISTS feature_trait("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_id INTEGER,"+
                    " name varchar(40)"+
                    ");");
            database.execSQL("CREATE TABLE IF NOT EXISTS weapon("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_id INTEGER,"+
                    " name varchar(40),"+
                    " attack_bonus TINYINT,"+
                    " damage varchar(10)"+
                    ");");
            database.execSQL("CREATE TABLE IF NOT EXISTS saving_skill_proficiency("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_id INTEGER,"+
                    " saving_skill_code varchar(3),"+
                    " modifier TINYINT"+
                    ");");
        }
        //database.execSQL("ALTER TABLE character ADD race varchar(20)");
        return database;
    }

    public static void insertCharacter(Character character){
        if(character.getId() == 0){
            getConnection().execSQL("INSERT INTO character("+
                    "character_name, class, race, background, "+
                    "alignment, strength, dexterity, constitution, "+
                    "intelligence, wisdom, charisma)"+
                    " VALUES(\""+
                    character.getName() + "\",\"" +
                    character.getClassType() + "\",\"" +
                    character.getRace() + "\",\"" +
                    character.getBackground() + "\",\"" +
                    character.getAlignment() + "\"," +
                    character.getStrength() + "," +
                    character.getDexterity() + "," +
                    character.getConstitution() + "," +
                    character.getIntelligence() + "," +
                    character.getWisdom() + "," +
                    character.getCharisma()+
                    ")");
        }
    }
    public static ArrayList<Character> getCharactersLowDetail(){
        Cursor cursor = getConnection().rawQuery("SELECT " +
                "id, character_name, race, class, " +
                "background, alignment, strength, " +
                "dexterity, constitution, intelligence, " +
                "wisdom, charisma " +
                "FROM character ORDER BY character_name",
                null
        );
        ArrayList<Character> characterList = new ArrayList<>(cursor.getCount());
        cursor.moveToFirst();
        do {
            Character character = new Character(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    (byte) cursor.getShort(6),
                    (byte) cursor.getShort(7),
                    (byte) cursor.getShort(8),
                    (byte) cursor.getShort(9),
                    (byte) cursor.getShort(10),
                    (byte) cursor.getShort(11)
            );
            characterList.add(character);

        }while (cursor.moveToNext());
        return characterList;
    }
}
