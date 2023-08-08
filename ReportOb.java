package com.example.frontendbihai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.EditText;

public class ReportOb extends AppCompatActivity {


    String reportText;
    EditText reportTextInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_ob);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        configurereportB();
        configureSwitch();
        configurereportT();

    }

    private void configureSwitch() {
        Switch swtich1 = (Switch) findViewById(R.id.switch1);
        swtich1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getBaseContext(), "You are reporting on current location", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Please provide the location you would like to report", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void configurereportT(){
        reportTextInput =   findViewById(R.id.textReport);
        reportText = reportTextInput.getText().toString();
    }


    private void configurereportB() {
        Button reportB = (Button) findViewById(R.id.reportB);
       reportB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
