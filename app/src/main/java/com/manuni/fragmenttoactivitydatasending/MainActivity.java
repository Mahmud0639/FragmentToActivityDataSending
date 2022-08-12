package com.manuni.fragmenttoactivitydatasending;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.manuni.fragmenttoactivitydatasending.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements DataSenderFragment.DataSendListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.showfragBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSenderFragment senderFragment = new DataSenderFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,senderFragment).commit();
            }
        });


    }

    @Override
    public void onDataFinish(Person person) {
        binding.nameTxt.setText(person.getName());
        binding.genderTxt.setText(person.getGender());
        binding.ageTxt.setText(person.getAge()+"");
    }
}