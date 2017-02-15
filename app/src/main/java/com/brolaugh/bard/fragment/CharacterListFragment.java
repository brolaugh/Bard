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


        PrimaryActivity.characterList = SQLiteConnection.getCharactersLowDetail();
        for (int i = 0; i < PrimaryActivity.characterList.size(); i++) {
            Button characterButton = new Button(getContext());
            characterButton.setTransformationMethod(null);
            characterButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            characterButton.setTag(PrimaryActivity.characterList.get(i).getId());
            characterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PrimaryActivity activity = (PrimaryActivity) getActivity();
                    PrimaryActivity.activeCharacter = activity.findCharacterWithID((Integer) v.getTag());
                    PrimaryActivity.activeCharacter.completeCharacter();
                    v.setTag("character_view_fragment");
                    activity.changeFragment(v);

                }
            });
            characterButton.setText(
                    PrimaryActivity.characterList.get(i).getName() + " " +
                            110 + " " +
                            PrimaryActivity.characterList.get(i).getRace() + " " +
                            PrimaryActivity.characterList.get(i).getClassType()
            );
            layout.addView(characterButton);
        }
        return view;
    }
}
