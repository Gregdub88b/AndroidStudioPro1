package com.example.cirrulumvitae;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.cirrulumvitae.data.Bio;
import com.example.cirrulumvitae.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    private final Bio bio = new Bio();
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        bio.setName("Greg Bujnowski");

        binding.setBio(bio);
        binding.button2.setOnClickListener(this::addHobbies);


    }

    public void addHobbies(View view) {


        bio.setHobbies(String.format("Hobbies :" + binding.enterYourHobbies.getText().toString()));


        binding.invalidateAll();
        binding.displayHobbies.setVisibility(View.VISIBLE);


        // hide keyboard

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);


    }
}