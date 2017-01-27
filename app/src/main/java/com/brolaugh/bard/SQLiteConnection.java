package com.brolaugh.bard;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteConnection {
    private static SQLiteDatabase database;
    private static Context context;

    public static void init(Context context) {
        SQLiteConnection.context = context;
    }
    private static SQLiteDatabase startUp(){
        if(database == null || !database.isOpen()){
            database = context.openOrCreateDatabase("bard.db",context.MODE_PRIVATE,null);
            //database.execSQL("DROP TABLE mix");

            database.execSQL("CREATE TABLE IF NOT EXISTS character("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_name varchar(60),"+
                    " player_name varchar(40),"+
                    " class varchar(20),"+
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
                    " ,"+
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
                    " damage varchar(10),"+
                    ");");
            database.execSQL("CREATE TABLE IF NOT EXISTS saving_skill_proficiency("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " character_id INTEGER,"+
                    " saving_skill_code varchar(3),"+
                    " modifier TINYINT"+
                    " ,"+
                    ");");
        }
        return database;
    }
}
