package com.brolaugh.bard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.SQLiteConnection;
import com.brolaugh.bard.datahandler.Character;

import java.util.ArrayList;

public class CharacterListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_character_list, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrimaryActivity pa = (PrimaryActivity) getActivity();
                view.setTag("character_list_create_character");
                pa.changeFragment(view);
            }
        });
        fab.setImageResource(R.mipmap.ic_launcher);
        fab.setMinimumHeight(150);
        fab.setMinimumWidth(150);
        fab.setMaxHeight(300);
        fab.setMaxWidth(300);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.character_list);
        ArrayList<Character> charactersList = SQLiteConnection.getCharactersLowDetail();
        for (int i = 0; i < charactersList.size(); i++) {
            Button characterButton = new Button(getContext());
            characterButton.setTransformationMethod(null);
            characterButton.setText(
                    charactersList.get(i).getName() + " " +
                            110 + " " +
                            charactersList.get(i).getRace() + " " +
                            charactersList.get(i).getClassType()
            );
            layout.addView(characterButton);
        }
        return view;
    }
}
