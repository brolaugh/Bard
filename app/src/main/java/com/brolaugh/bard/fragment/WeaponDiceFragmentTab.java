package com.brolaugh.bard.fragment;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.brolaugh.bard.PrimaryActivity;
import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.Dice;
import com.brolaugh.bard.datahandler.RollBreakDown;

public class WeaponDiceFragmentTab extends Fragment {
    private View rootView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.skill_dice_fragment_tab, container, false);
        rootView = view;
        Button rollButton = (Button) view.findViewById(R.id.rollAdvancedDiceButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
        return view;
    }

    public void roll() {
        Spinner spinner = (Spinner) rootView.findViewById(R.id.advanced_dice_spinner);

        Dice roller = new Dice("1D20");
        RollBreakDown breakDown = new RollBreakDown();
        short result = 0;

        Vibrator viber = (Vibrator) getActivity().getSystemService(getContext().VIBRATOR_SERVICE);
        viber.vibrate(70);

        TextView resultText = (TextView) rootView.findViewById(R.id.advancedDiceRollResult);
        short diceResult = roller.roll();
        result = diceResult;
        breakDown.addEntry("Roll: " + diceResult + " (" + roller.getRolledDice() + ")");

        result += PrimaryActivity.activeCharacter.getInitiative();
        breakDown.addEntry("Initiative: " + PrimaryActivity.activeCharacter.getInitiative());

        resultText.setText(String.valueOf(result));
        TextView resultBreakDown = (TextView) rootView.findViewById(R.id.advancedDiceRollResultBreakDown);
        resultBreakDown.setText(breakDown.getStringBreakdown());
    }
}
