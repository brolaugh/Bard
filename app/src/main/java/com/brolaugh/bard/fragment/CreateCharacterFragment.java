package com.brolaugh.bard.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.TextInputEditText;
import android.widget.LinearLayout;

import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.Character;

public class CreateCharacterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_character, container, false);
        setOnClickCollapsable(view, R.id.character_creation_general_button, R.id.character_creation_general_layout);
        setOnClickCollapsable(view, R.id.character_creation_attributes_button, R.id.character_creation_attributes_layout);

        Button submitButton = (Button) view.findViewById(R.id.create_character_submit);
        submitButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCharacter();
            }
        });

        return view;

    }
    private void createCharacter(){
        Activity activity = getActivity();

        TextInputEditText characterName = (TextInputEditText) activity.findViewById(R.id.character_name_input);
        TextInputEditText characterRace = (TextInputEditText) activity.findViewById(R.id.character_race_input);
        TextInputEditText characterClass = (TextInputEditText) activity.findViewById(R.id.character_class_input);
        TextInputEditText characterBackground = (TextInputEditText) activity.findViewById(R.id.character_background_input);
        TextInputEditText characterAlignment = (TextInputEditText) activity.findViewById(R.id.character_alignment_input);

        TextInputEditText characterStrength = (TextInputEditText) activity.findViewById(R.id.character_strength_input);
        TextInputEditText characterDexterity = (TextInputEditText) activity.findViewById(R.id.character_dexterity_input);
        TextInputEditText characterConstitution = (TextInputEditText) activity.findViewById(R.id.character_constitution_input);
        TextInputEditText characterIntelligence = (TextInputEditText) activity.findViewById(R.id.character_intelligence_input);
        TextInputEditText characterWisdom = (TextInputEditText) activity.findViewById(R.id.character_wisdom_input);
        TextInputEditText characterCharisma = (TextInputEditText) activity.findViewById(R.id.character_charisma_input);

        byte characterStrengthValue = Byte.parseByte(characterStrength.getText().toString());
        byte characterDexterityValue = Byte.parseByte(characterDexterity.getText().toString());
        byte characterConstitutionValue = Byte.parseByte(characterConstitution.getText().toString());
        byte characterIntelligenceValue = Byte.parseByte(characterIntelligence.getText().toString());
        byte characterWisdomValue = Byte.parseByte(characterWisdom.getText().toString());
        byte characterCharismaValue = Byte.parseByte(characterCharisma.getText().toString());

        Character character =  new Character(
                characterName.getText().toString(),
                characterRace.getText().toString(),
                characterClass.getText().toString(),
                characterBackground.getText().toString(),
                characterAlignment.getText().toString(),
                characterStrengthValue,
                characterDexterityValue,
                characterConstitutionValue,
                characterIntelligenceValue,
                characterWisdomValue,
                characterCharismaValue
                );
        character.save();

    }
    private void setOnClickCollapsable(View view, int clickView, final int targetView){
        Button formCollapseButton  = (Button) view.findViewById(clickView);
        formCollapseButton.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_collapse_00015, 0);
        formCollapseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                LinearLayout layout = (LinearLayout) getActivity().findViewById(targetView);
                if(layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                    clickedButton.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_collapse, 0);
                }else{
                    layout.setVisibility(View.VISIBLE);
                    clickedButton.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_collapse_00015, 0);
                }
            }
        });
    }
}
