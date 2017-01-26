package com.brolaugh.bard;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.brolaugh.bard.datahandler.Character;
import com.brolaugh.bard.fragment.CharacterListFragment;
import com.brolaugh.bard.fragment.MainMenuFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Character activeCharacter;
    public static ArrayList<Character> characterList;
    public FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.activity_main, new MainMenuFragment());
        transaction.commit();

    }

    public void changeFragment(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getTag().toString()) {
            case "main_menu_characters":
                transaction.replace(R.id.activity_main, new CharacterListFragment()).addToBackStack("character_list");
                break;

        }
        transaction.commit();
    }
}
