package com.demo.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
EditText enterO, enterN1, enterN2;
String StrO, StrN1, StrN2, resultMsg, StrResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSolve = findViewById(R.id.button);

        btnSolve.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Toast.makeText(this, "Solving....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }
    public void ComputeResult(){
        enterO = findViewById(R.id.enterO);
        enterN1 = findViewById(R.id.enterN1);
        enterN2 = findViewById(R.id.enterN2);

        if(enterO.getText().toString().isEmpty() || enterN1.getText().toString().isEmpty() || enterN2.getText().toString().isEmpty()){
            StrO = "0";
            StrN1 = "0";
            StrN2 = "0";
        }
        else{
            StrO = enterO.getText().toString();
            StrN1 = enterN1.getText().toString();
            StrN2 = enterN2.getText().toString();
        }
        int enterO = Integer.parseInt(StrO);
        int Operator = Integer.parseInt(StrO);
        int N1 = Integer.parseInt(StrN1);
        int N2 = Integer.parseInt(StrN2);

        switch(Operator){
            case 1:
                Operator = N1 + N2;
                break;
            case 2:
                Operator = N1 - N2;
                break;
            case 3:
                Operator = N1 * N2;
                break;
            case 4:
                Operator = N1 / N2;
                break;
        }
        int result = Operator;

        resultMsg = "The 1st number that you input is " + StrN1 +
                "\n The 2nd Number that you input is " + StrN2 +
                "\n The operator that you choose is " + StrO +
                "\n\n\n So therefore your result is " + result;

        Bundle args = new Bundle();
        args.putString("result", resultMsg);

        Intent intent;
        if(enterO == 1){
            intent = new Intent(MainActivity.this, addition_result.class);
        }
        else if(enterO == 2){
            intent = new Intent(MainActivity.this, subtraction_result.class);
        }
        else if(enterO == 3){
            intent = new Intent(MainActivity.this, multiplication_result.class);
        }
        else{
            intent = new Intent(MainActivity.this, division_result.class);
        }
        intent.putExtras(args);
        startActivity(intent);
        clearEditText();
    }
    public void clearEditText(){
        enterO.getText().clear();
        enterN1.getText().clear();
        enterN2.getText().clear();
        enterO.requestFocus();
    }
}