package com.brolaugh.bard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.brolaugh.bard.R;

public class CreateCharacterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_character, container, false);
        setOnClickCollapsable(view, R.id.character_creation_general_button, R.id.character_creation_general_layout);
        setOnClickCollapsable(view, R.id.character_creation_attributes_button, R.id.character_creation_attributes_layout);

        return view;

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
