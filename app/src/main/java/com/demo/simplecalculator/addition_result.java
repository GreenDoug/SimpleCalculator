package com.demo.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addition_result extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle saveInstanceSate){
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.addition_result);

        Bundle extras = getIntent().getExtras();
        String result = extras.getString("result");
        setContentView(R.layout.addition_result);

        Button btnReturn = findViewById(R.id.btnReturn);
        TextView tvResult = findViewById(R.id.txtresult);
        tvResult.setText(result);
        btnReturn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent(addition_result.this, MainActivity.class);
        startActivity(intent);
    }
}
