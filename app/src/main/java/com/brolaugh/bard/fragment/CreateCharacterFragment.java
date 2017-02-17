package com.brolaugh.bard.fragment;


import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.LinearLayout;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.Character;

public class CreateCharacterFragment extends CharacterCreationFragment {

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

        byte characterStrengthValue = Byte.parseByte(characterStrength.getText().toString());
        byte characterDexterityValue = Byte.parseByte(characterDexterity.getText().toString());
        byte characterConstitutionValue = Byte.parseByte(characterConstitution.getText().toString());
        byte characterIntelligenceValue = Byte.parseByte(characterIntelligence.getText().toString());
        byte characterWisdomValue = Byte.parseByte(characterWisdom.getText().toString());
        byte characterCharismaValue = Byte.parseByte(characterCharisma.getText().toString());
        byte characterInitiativeValue = Byte.parseByte(characterInitiative.getText().toString());

        Character character = new Character(
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
        character.setInitiative(characterInitiativeValue);
        LinearLayout savingThrowLayout = (LinearLayout) activity.findViewById(R.id.character_creation_saving_throw_layout);
        getSavingSkillProficiencies();
        character.save();
        PrimaryActivity.activeCharacter = character;

        //Place the character in the correct position in the characterList
        for (int i = 0; i <= PrimaryActivity.characterList.size(); i++) {
            if (i == PrimaryActivity.characterList.size()) {
                PrimaryActivity.characterList.add(character);
                break;
            } else if (i == 0 && PrimaryActivity.characterList.get(i).getName().compareToIgnoreCase(character.getName()) < 0) {
                PrimaryActivity.characterList.add(0, character);
                break;
            } else if (PrimaryActivity.characterList.get(i).getName().compareToIgnoreCase(character.getName()) == 0) {
                PrimaryActivity.characterList.add(i, character);
                break;
            }
        }
        View fragmentChanger = new View(getContext());
        fragmentChanger.setTag("character_view_fragment");
        activity.changeFragment(fragmentChanger);
        super.saveCharacter();
    }

}