package com.projects.ztong.demoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button demoButton = (Button) findViewById(R.id.demo_button);
        demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDemoButtonClick();
            }
        });
    }

    private void onDemoButtonClick() {
        Toast.makeText(this, "App is not hooked.", Toast.LENGTH_LONG).show();
    }
}
