package com.brolaugh.bard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.brolaugh.bard.datahandler.Character;
import com.brolaugh.bard.fragment.CharacterListFragment;
import com.brolaugh.bard.fragment.CreateCharacterFragment;
import com.brolaugh.bard.fragment.MainMenuFragment;
import com.brolaugh.bard.fragment.SimpleDiceFragment;

import java.util.ArrayList;

public class PrimaryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    public static Character activeCharacter;
    public static ArrayList<Character> characterList;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle(R.string.app_name);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_primary, new MainMenuFragment());
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.primary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (id == R.id.nav_main_menu) {
            transaction.replace(R.id.content_primary, new MainMenuFragment()).addToBackStack(null);
        } else if (id == R.id.nav_simple_dice) {
            transaction.replace(R.id.content_primary, new SimpleDiceFragment()).addToBackStack(null);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragment(View view) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getTag().toString()) {
            case "main_menu_characters":
                transaction.replace(R.id.content_primary, new CharacterListFragment()).addToBackStack("character_list");
                break;
            case "main_menu_simple_dice":
                transaction.replace(R.id.content_primary, new SimpleDiceFragment()).addToBackStack(null);
                navigationView.setCheckedItem(R.id.nav_simple_dice);
                break;
            case "character_list_create_character":
                transaction.replace(R.id.content_primary, new CreateCharacterFragment()).addToBackStack(null);
                break;
            case "main_menu":
                transaction.replace(R.id.content_primary, new MainMenuFragment()).addToBackStack(null);
                navigationView.setCheckedItem(R.id.nav_main_menu);
                break;

        }
        transaction.commit();
    }
}
