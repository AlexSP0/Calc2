package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActivityChooseTheme extends AppCompatActivity implements View.OnClickListener {
    public static final String CALCULATOR_THEME = "CALC_THEME";
    public static final String CHANGE_THEME ="NAME_CHANGE_THEME";
    public static final int DARK_THEME = 0;
    public static final int LIGHT_THEME = 1;
    Button buttonChoose;
    Button buttonCancel;
    RadioButton radioButtonLightTheme;
    RadioButton radioButtonDarkTheme;
    RadioGroup radioButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_theme);
        initResources();
        getThemeFromPreferences();

    }

    private void getThemeFromPreferences() {
        SharedPreferences pref = getSharedPreferences(CALCULATOR_THEME,MODE_PRIVATE);
        switch (pref.getInt(CALCULATOR_THEME,-1)) {
            case DARK_THEME:
                radioButtons.check(R.id.radioButtonDarkTheme);
                break;
            case LIGHT_THEME:
                radioButtons.check(R.id.radioButtonLightTheme);
                break;
        }
    }

    private void initResources() {
        buttonChoose = findViewById(R.id.buttonChooseTheme);
        buttonCancel = findViewById(R.id.buttonCancel);
        radioButtonDarkTheme = findViewById(R.id.radioButtonDarkTheme);
        radioButtonLightTheme = findViewById(R.id.radioButtonLightTheme);
        radioButtons  =findViewById(R.id.radioGroupThemeButtons);
        buttonChoose.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonChooseTheme:
                if(radioButtonLightTheme.isChecked()){
                    saveThemeInSharedPreferences(LIGHT_THEME);
                } else {
                    saveThemeInSharedPreferences(DARK_THEME);
                }
                finish();
                break;
            case R.id.buttonCancel:
                finish();
                break;
        }
    }

    private void saveThemeInSharedPreferences(int th) {
        SharedPreferences pref = getSharedPreferences(CALCULATOR_THEME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(CALCULATOR_THEME, th);
        editor.putInt(CHANGE_THEME,1);
        editor.apply();
    }
}