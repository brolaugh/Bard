package com.brolaugh.bard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.Character;

public class EditCharacterFragment extends CharacterCreationFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

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



        characterName.setText(PrimaryActivity.activeCharacter.getName());
        characterRace.setText(PrimaryActivity.activeCharacter.getRace());
        characterClass.setText(PrimaryActivity.activeCharacter.getClassType());
        characterBackground.setText(PrimaryActivity.activeCharacter.getBackground());
        characterAlignment.setText(PrimaryActivity.activeCharacter.getAlignment());

        characterStrength.setText(String.valueOf(PrimaryActivity.activeCharacter.getStrength()));
        characterDexterity.setText(String.valueOf(PrimaryActivity.activeCharacter.getDexterity()));
        characterConstitution.setText(String.valueOf(PrimaryActivity.activeCharacter.getConstitution()));
        characterIntelligence.setText(String.valueOf(PrimaryActivity.activeCharacter.getIntelligence()));
        characterWisdom.setText(String.valueOf(PrimaryActivity.activeCharacter.getWisdom()));
        characterCharisma.setText(String.valueOf(PrimaryActivity.activeCharacter.getCharisma()));

        Button saveButton = (Button) view.findViewById(R.id.create_character_submit);
        saveButton.setText(R.string.create_charcter_save);
        return view;
    }

    @Override
    protected void saveCharacter() {
        PrimaryActivity activity = (PrimaryActivity) getActivity();

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

        PrimaryActivity.activeCharacter.setName(characterName.getText().toString());
        PrimaryActivity.activeCharacter.setRace(characterRace.getText().toString());
        PrimaryActivity.activeCharacter.setClassType(characterClass.getText().toString());
        PrimaryActivity.activeCharacter.setBackground(characterBackground.getText().toString());
        PrimaryActivity.activeCharacter.setAlignment(characterAlignment.getText().toString());

        PrimaryActivity.activeCharacter.setStrength(Byte.parseByte(characterStrength.getText().toString()));
        PrimaryActivity.activeCharacter.setDexterity(Byte.parseByte(characterDexterity.getText().toString()));
        PrimaryActivity.activeCharacter.setConstitution(Byte.parseByte(characterConstitution.getText().toString()));
        PrimaryActivity.activeCharacter.setIntelligence(Byte.parseByte(characterIntelligence.getText().toString()));
        PrimaryActivity.activeCharacter.setWisdom(Byte.parseByte(characterWisdom.getText().toString()));
        PrimaryActivity.activeCharacter.setCharisma(Byte.parseByte(characterCharisma.getText().toString()));

        View fragmentChanger = new View(getContext());
        fragmentChanger.setTag("character_view_fragment");
        activity.changeFragment(fragmentChanger);
        Snackbar snackbar = Snackbar
                .make(getView(), "Character Saved", Snackbar.LENGTH_SHORT);

        snackbar.show();
    }


}
