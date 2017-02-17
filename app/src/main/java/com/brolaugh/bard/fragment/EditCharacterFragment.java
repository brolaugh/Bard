package com.brolaugh.bard.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.SavingSkillProficiency;

import java.util.ArrayList;

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
        TextInputEditText characterInitiative = (TextInputEditText) view.findViewById(R.id.character_initiative_input);

        final LinearLayout savingThrowLayout = (LinearLayout) view.findViewById(R.id.character_creation_saving_throw_layout);

        for(int i = 0; i < PrimaryActivity.activeCharacter.getSavingSkillProficiencies().size();i++){
            SavingSkillProficiency currentSavingSkill = PrimaryActivity.activeCharacter.getSavingSkillProficiencies().get(i);

            final LinearLayout proficiencyRow = (LinearLayout) inflater.inflate(
                    R.layout.create_character_proficiency,
                    savingThrowLayout,
                    false
            );

            Spinner spinner = (Spinner) proficiencyRow.getChildAt(0);
            TextInputLayout amountInput = (TextInputLayout) proficiencyRow.getChildAt(1);
            amountInput.getEditText().setText(String.valueOf(currentSavingSkill.getModifierAmount()));
            Log.d("spinner", String.valueOf(spinner.getChildCount()));

            for(int c = 0; c < spinnerSize;c++){
                String compareString = new SavingSkillProficiency(spinner.getItemAtPosition(c).toString(),(byte) 0).getModifierType();

                Log.d("comp", compareString + " vs " + currentSavingSkill.getModifierType());

                if(currentSavingSkill.getModifierType().equalsIgnoreCase(compareString)){
                    spinner.setSelection(c);
                }
            }
            proficiencyRow.getChildAt(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View deleteProficiencyButton) {
                    savingThrowLayout.removeView(proficiencyRow);
                }
            });
            savingThrowLayout.addView(proficiencyRow, savingThrowLayout.getChildCount()-1);
        }

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
        characterInitiative.setText(String.valueOf(PrimaryActivity.activeCharacter.getInitiative()));

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
        TextInputEditText characterInitiative = (TextInputEditText) activity.findViewById(R.id.character_initiative_input);

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
        PrimaryActivity.activeCharacter.setInitiative(Byte.parseByte(characterInitiative.getText().toString()));


        PrimaryActivity.activeCharacter.replaceSavingSkillProficiencies(getSavingSkillProficiencies());
        PrimaryActivity.activeCharacter.save();
        View fragmentChanger = new View(getContext());
        fragmentChanger.setTag("character_view_fragment");
        activity.changeFragment(fragmentChanger);
        super.saveCharacter();
    }


}
