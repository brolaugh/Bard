package com.brolaugh.bard.fragment;


import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.brolaugh.bard.R;
import com.brolaugh.bard.datahandler.Dice;

public class SimpleDiceFragment extends Fragment {
    protected View rootView;
    private int spinnerPosition = 5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_dice, container, false);
        rootView = view;
        final Spinner spinner = (Spinner) rootView.findViewById(R.id.simpleDiceSpinner);
        spinner.setSelection(spinnerPosition);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setSelection(spinnerPosition);
            }
        });
        Button rollButton = (Button) view.findViewById(R.id.rollSimpleDiceButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll(v);
            }
        });
        return view;
    }

    public void roll(View view) {
        Spinner spinner = (Spinner) rootView.findViewById(R.id.simpleDiceSpinner);

        Dice roller = new Dice("1" + spinner.getSelectedItem().toString());

        Vibrator viber = (Vibrator) getActivity().getSystemService(getContext().VIBRATOR_SERVICE);
        viber.vibrate(70);

        TextView resultText = (TextView) rootView.findViewById(R.id.simpleDiceRollResult);
        String rollResult = String.valueOf(roller.roll());
        resultText.setText(rollResult);

        TextView resultBreakDown = (TextView) rootView.findViewById(R.id.simpleDiceRollResultBreakDown);
        resultBreakDown.setText("Roll: "+rollResult+" (1"+spinner.getSelectedItem().toString()+")");
    }
}
