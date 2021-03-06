package com.brolaugh.bard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.SavingSkillProficiency;

import java.util.ArrayList;

public abstract class CharacterCreationFragment extends Fragment {
    public static final int spinnerSize = 13;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_character, container, false);
        setOnClickCollapsable(view, R.id.character_creation_general_button, R.id.character_creation_general_layout);
        setOnClickCollapsable(view, R.id.character_creation_attributes_button, R.id.character_creation_attributes_layout);
        setOnClickCollapsable(view, R.id.character_creation_saving_throw_button, R.id.character_creation_saving_throw_layout);


        final Button proficiencyAdderButton = (Button) view.findViewById(R.id.create_character_add_proficiency);
        proficiencyAdderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View proficiencyAdderButton) {
                final LinearLayout proficiencyList = (LinearLayout) getActivity().findViewById(R.id.character_creation_saving_throw_layout);

                final LinearLayout proficiencyRow = (LinearLayout) getLayoutInflater(null).inflate(R.layout.create_character_proficiency, proficiencyList, false);
                proficiencyRow.getChildAt(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View deleteProficiencyButton) {
                        proficiencyList.removeView(proficiencyRow);
                    }
                });
                proficiencyList.removeViewAt(proficiencyList.getChildCount() - 1);
                proficiencyList.addView(proficiencyRow, proficiencyList.getChildCount());
                proficiencyList.addView(proficiencyAdderButton);
            }
        });
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


    protected void saveCharacter(){
        Snackbar snackbar = Snackbar
                .make(getView(), "Character Saved", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

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

        LinearLayout savingThrowLayout = (LinearLayout) view.findViewById(R.id.character_creation_saving_throw_layout);
        for(int i = savingThrowLayout.getChildCount()-2; i > 2;i--){
            if(savingThrowLayout.getChildAt(i).getId() == R.id.create_character_add_proficiency){
                savingThrowLayout.removeViewAt(i);
            }
        }
        if(savingThrowLayout.getChildCount() > 1){
            LinearLayout savingThrowRow = (LinearLayout) savingThrowLayout.getChildAt(0);
            ((Spinner) savingThrowRow.getChildAt(0)).setSelection(0);
            ((TextInputEditText) savingThrowRow.getChildAt(1)).setText("");
        }

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

    public ArrayList<SavingSkillProficiency> getSavingSkillProficiencies(){
        LinearLayout savingThrowLayout = (LinearLayout) getView().findViewById(R.id.character_creation_saving_throw_layout);
        ArrayList<SavingSkillProficiency> savingSkillArray = new ArrayList<>();
        Log.d("Save called", "ye");
        for(int i = 0; i < savingThrowLayout.getChildCount()-1;i++){
            LinearLayout row = (LinearLayout) savingThrowLayout.getChildAt(i);
            String modifierType = ((Spinner)row.getChildAt(0)).getSelectedItem().toString();
            TextInputLayout til = (TextInputLayout)row.getChildAt(1);

            Byte modifierAmount = Byte.parseByte(til.getEditText().getText().toString());
            SavingSkillProficiency ssp = new SavingSkillProficiency(modifierType, modifierAmount);
            savingSkillArray.add(ssp);
            Log.d("spara", String.valueOf(ssp.getModifierAmount()));
        }
        return savingSkillArray;
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
