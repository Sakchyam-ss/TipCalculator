package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private EditText costOfServiceText;

     private Button calcButton;

     private RadioGroup radioGroup;

     private Switch roundUpSwitch;

     private TextView tipAmountText;

     private double tipAmount;

     private double tipPercentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        costOfServiceText = findViewById(R.id.cost_of_service);
        calcButton = findViewById(R.id.calculate_button);
        radioGroup = findViewById(R.id.radioGroup);
        roundUpSwitch = findViewById(R.id.round_up_switch);
        tipAmountText = findViewById(R.id.tip_result);

        calcButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                String cost = costOfServiceText.getText().toString();
                int costAmount = Integer.parseInt(cost);
                int checkedRadioButton = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButton == R.id.option_twenty_percent){
                    tipPercentage = 0.2;
                } else if (checkedRadioButton == R.id.option_eighteen_percent) {
                    tipPercentage = 0.18;
                } else if (checkedRadioButton == R.id.option_fifteen_percent) {
                    tipPercentage = 0.15;
                }else{
                    tipPercentage = 0.0;
                }

                tipAmount = costAmount * tipPercentage;
                if (roundUpSwitch.isChecked()) {
                    tipAmount = Math.round(tipAmount);
                }

                tipAmountText.setText(""+tipAmount);
            }
        });


    }
}