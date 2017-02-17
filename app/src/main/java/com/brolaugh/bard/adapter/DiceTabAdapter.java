package com.brolaugh.bard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.brolaugh.bard.fragment.InitiativeDiceFragmentTab;
import com.brolaugh.bard.fragment.SkillDiceFragmentTab;
import com.brolaugh.bard.fragment.WeaponDiceFragmentTab;

public class DiceTabAdapter extends FragmentStatePagerAdapter {
    public DiceTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SkillDiceFragmentTab();
            case 1:
                return new WeaponDiceFragmentTab();
            case 2:
                return new InitiativeDiceFragmentTab();
            default:
                Log.d("DiceTabAdapter", "Fragment index "+position+"requested "+3+" exists");
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
