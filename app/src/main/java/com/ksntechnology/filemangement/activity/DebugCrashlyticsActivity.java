package com.ksntechnology.filemangement.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import com.ksntechnology.filemangement.R;

public class DebugCrashlyticsActivity extends AppCompatActivity
        implements View.OnClickListener{

    private Button btnCustom;
    private Button btnForce;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_crashlytics);

        initInstance();
    }

    private void initInstance() {
        btnForce = findViewById(R.id.button_ForceCrash);
        btnCustom = findViewById(R.id.button_CustomCrash);

        /*btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });*/
        btnCustom.setOnClickListener(this);
        btnForce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_CustomCrash:
                Log.d("HelloDebug","Hello Crashlytics");
                throw new ArrayIndexOutOfBoundsException();
                //break;
            case R.id.button_ForceCrash:
                Log.d("HelloDebug","Hello Crashlytics XZ");
                break;
        }
    }
}
