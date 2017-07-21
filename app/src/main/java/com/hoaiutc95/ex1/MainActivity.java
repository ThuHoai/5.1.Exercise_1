package com.hoaiutc95.ex1;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton mRed, mBlue, mYellow;
    private TextView showColorText;
    private RadioGroup radioGroup;
    private ToggleButton tgButtonRed, tgButtonYellow, tgButtonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        mRed.setOnClickListener(new ImageButtonColorChange());
        mBlue.setOnClickListener(new ImageButtonColorChange());
        radioGroup.setOnCheckedChangeListener(new RadioGroupColorChange());
        tgButtonRed.setOnClickListener(new ToggleButtonClick());
        tgButtonYellow.setOnClickListener(new ToggleButtonClick());
        tgButtonBlue.setOnClickListener(new ToggleButtonClick());
    }

    public void AnhXa(){
        mRed = (ImageButton) findViewById(R.id.ibtn_red);
        mBlue = (ImageButton) findViewById(R.id.ibtn_blue);
        showColorText = (TextView) findViewById(R.id.tvColorChange);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        tgButtonRed = (ToggleButton) findViewById(R.id.toggle_button_red);
        tgButtonYellow = (ToggleButton) findViewById(R.id.toggle_button_yellow);
        tgButtonBlue = (ToggleButton) findViewById(R.id.toggle_button_blue);
    }

    private void setColor(int i){
        showColorText.setBackgroundColor(i);
    }

    private class ImageButtonColorChange implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ibtn_red: {
                    setColor(Color.RED);
                } break;
                case R.id.ibtn_blue: {
                    setColor(Color.BLUE);
                } break;
                default:
                    //No something
                    break;
            }
        }
    }

    private class RadioGroupColorChange implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            int idChecked = group.getCheckedRadioButtonId();
            switch (idChecked){
                case R.id.rbtn0: {
                    setColor(Color.RED);
                } break;
                case R.id.rbtn1: {
                    setColor(Color.YELLOW);
                } break;
                case R.id.rbtn2: {
                    setColor(Color.BLUE);
                } break;
                default:
                    //No something
                    break;
            }
        }
    }

    private class ToggleButtonClick implements View.OnClickListener{

        public void showColorChange(int color1, int color2, View clickedToggleButton){
            ToggleButton toggleButton = (ToggleButton) clickedToggleButton;
            if(toggleButton.isChecked()){
                setColor(color1);
            }else {
                setColor(color2);
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.toggle_button_red: {
                    showColorChange(Color.RED,Color.BLACK,v);
                } break;
                case R.id.toggle_button_yellow: {
                    showColorChange(Color.YELLOW,Color.BLACK,v);
                } break;
                case R.id.toggle_button_blue: {
                    showColorChange(Color.BLUE,Color.BLACK,v);
                } break;
                default:
                    //do something;
                break;
            }

        }
    }

}
