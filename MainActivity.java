package com.example.frontendbihai;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String destination;
    double searchRadius;

    EditText destinationInput;
    EditText radiusInput;


    public void configureTextInputs(){
        destinationInput =  findViewById(R.id.AddressInput);
        radiusInput =   findViewById(R.id.radiusInput);
    }

    public void configureStartButton(){
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //store user input destination and desired radius

                Intent intent = new Intent(MainActivity.this, searchReportActivity.class);
                destination = destinationInput.getText().toString();
                //if(Double.valueOf(radiusInput.getText().toString()) >= 0 )
                searchRadius = Double.valueOf(radiusInput.getText().toString());


                intent.putExtra("dest", destination);

                intent.putExtra("distance", searchRadius);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        configureTextInputs();
        configureStartButton();

    }


}
