package com.manuni.fragmenttoactivitydatasending;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manuni.fragmenttoactivitydatasending.databinding.FragmentDataSenderBinding;


public class DataSenderFragment extends Fragment {
    FragmentDataSenderBinding binding;
    private DataSendListener mDataSendListener;


    public DataSenderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataSenderBinding.inflate(inflater, container, false);

        binding.sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameData = binding.nameET.getText().toString();
                String genderData = binding.genderET.getText().toString();
                int ageData = Integer.parseInt(binding.ageET.getText().toString());

                Person person = new Person();
                person.setName(nameData);
                person.setGender(genderData);
                person.setAge(ageData);

                mDataSendListener.onDataFinish(person);


            }
        });
        return binding.getRoot();
    }


    //getting reference
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DataSendListener){
            mDataSendListener = (DataSendListener) context;
        }
    }

    public interface DataSendListener{
        void onDataFinish(Person person);
    }
}