package com.example.frontendbihai;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class searchReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_report);
        configureBackButton();
        configureAlternateRoute();
        configureReportOb();
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void configureAlternateRoute(){
        Button backButton = (Button) findViewById(R.id.alternateRoute);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //write to get an obstacle
            }
        });    }

    private void configureReportOb() {
        Button reportButton = (Button) findViewById(R.id.reportButton);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent haha = new Intent(searchReportActivity.this, ReportOb.class);
                startActivity(haha);
            }
        });
    }
}
