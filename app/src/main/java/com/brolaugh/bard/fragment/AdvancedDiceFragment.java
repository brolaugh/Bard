package com.brolaugh.bard.fragment;


import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.adapter.DiceTabAdapter;
import com.brolaugh.bard.datahandler.Dice;

public class AdvancedDiceFragment extends Fragment {
    protected View rootView;
    private int spinnerPosition = 5;
    private TabLayout.Tab skillTab;
    private TabLayout.Tab  weaponTab;
    private TabLayout.Tab initiativeTab;

    private Spinner skillSpinner;
    private Spinner weaponSpinner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advanced_dice, container, false);
        rootView = view;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        skillTab = tabLayout.newTab().setText(R.string.skill);
        weaponTab = tabLayout.newTab().setText(R.string.weapon);
        initiativeTab = tabLayout.newTab().setText(R.string.initative);

        tabLayout.addTab(skillTab);
        tabLayout.addTab(weaponTab);
        tabLayout.addTab(initiativeTab);

        PrimaryActivity pa = (PrimaryActivity) getActivity();
        DiceTabAdapter pagerAdapter = new DiceTabAdapter(pa.fragmentManager);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
}
