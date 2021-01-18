package com.example.alarms;

import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


public class AdditionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private ConstraintLayout con_backToAdd;
    private FrameLayout frm_save;

    FrameLayout frame_add_setting;
    private IReferenceLayouts mListener;

    public AdditionFragment() {

    }



    public static AdditionFragment newInstance(String param1, String param2) {
        AdditionFragment fragment = new AdditionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_addition, container, false);

         frame_add_setting = v.findViewById(R.id.frame_add_setting);


        Button b = (Button)v.findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Merhaba", Toast.LENGTH_SHORT).show();
            }
        });

        LayoutInflater.from(getContext()).inflate(R.layout.addition_lyt, frame_add_setting, true);

        con_backToAdd = (ConstraintLayout)v.findViewById(R.id.con_backToAdd);
        frm_save = (FrameLayout)v.findViewById(R.id.frm_save);

        con_backToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                con_backToAdd.setVisibility(View.GONE);
                frm_save.setVisibility(View.VISIBLE);
                frame_add_setting.removeAllViews();
                LayoutInflater.from(getContext()).inflate(R.layout.addition_lyt, frame_add_setting, true);


            }
        });

        mListener.setReferences(frm_save,con_backToAdd,frame_add_setting);

        return v;
    }

/*
    private void setClickListeners()
    {
        con_alarmSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(getContext(),"Merhaba",Toast.LENGTH_SHORT).show();
                click_con_alarmSound();

            }
        });
        con_dismissby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_con_dismissby();
            }
        });
        con_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_con_label();
            }
        });
        con_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_con_repeat();
            }
        });
        con_snooze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_con_snooze();
            }
        });
    }

    private void click_con_dismissby()
    {

    }

    private void click_con_alarmSound()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.alarm_sound_lyt, frame_add_setting, true);
    }
    private void click_con_label()
    {

    }
    private void click_con_repeat()
    {

    }
    private void click_con_snooze()
    {

    }



 */



    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof IReferenceLayouts) {
            mListener = (IReferenceLayouts) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface IReferenceLayouts {
        // TODO: Update argument type and name
        void setReferences(FrameLayout frameLayout,ConstraintLayout constraintLayout,FrameLayout frameLayout2);
    }


}
