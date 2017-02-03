package com.brolaugh.bard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.brolaugh.bard.R;

public abstract class CharacterCreationFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_character, container, false);
        setOnClickCollapsable(view, R.id.character_creation_general_button, R.id.character_creation_general_layout);
        setOnClickCollapsable(view, R.id.character_creation_attributes_button, R.id.character_creation_attributes_layout);

        Button submitButton = (Button) view.findViewById(R.id.create_character_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCharacter();
            }
        });
        clearInputs(view);
        return view;

    }

    abstract protected void saveCharacter();

    protected void clearInputs(View view) {
        TextInputEditText characterName = (TextInputEditText) view.findViewById(R.id.character_name_input);
        TextInputEditText characterRace = (TextInputEditText) view.findViewById(R.id.character_race_input);
        TextInputEditText characterClass = (TextInputEditText) view.findViewById(R.id.character_class_input);
        TextInputEditText characterBackground = (TextInputEditText) view.findViewById(R.id.character_background_input);
        TextInputEditText characterAlignment = (TextInputEditText) view.findViewById(R.id.character_alignment_input);

        TextInputEditText characterStrength = (TextInputEditText) view.findViewById(R.id.character_strength_input);
        TextInputEditText characterDexterity = (TextInputEditText) view.findViewById(R.id.character_dexterity_input);
        TextInputEditText characterConstitution = (TextInputEditText) view.findViewById(R.id.character_constitution_input);
        TextInputEditText characterIntelligence = (TextInputEditText) view.findViewById(R.id.character_intelligence_input);
        TextInputEditText characterWisdom = (TextInputEditText) view.findViewById(R.id.character_wisdom_input);
        TextInputEditText characterCharisma = (TextInputEditText) view.findViewById(R.id.character_charisma_input);

        characterName.setText("");
        characterRace.setText("");
        characterClass.setText("");
        characterBackground.setText("");
        characterAlignment.setText("");

        characterStrength.setText("");
        characterDexterity.setText("");
        characterConstitution.setText("");
        characterIntelligence.setText("");
        characterWisdom.setText("");
        characterCharisma.setText("");
    }

    private void setOnClickCollapsable(View view, int clickView, final int targetView) {
        Button formCollapseButton = (Button) view.findViewById(clickView);
        formCollapseButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_collapse_00015, 0);
        formCollapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                LinearLayout layout = (LinearLayout) getActivity().findViewById(targetView);
                if (layout.getVisibility() == View.VISIBLE) {
                    layout.setVisibility(View.GONE);
                    clickedButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_collapse, 0);
                } else {
                    layout.setVisibility(View.VISIBLE);
                    clickedButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_collapse_00015, 0);
                }
            }
        });
    }
}
