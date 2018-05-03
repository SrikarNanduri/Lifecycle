package com.example.android.lifecycle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = LifecycleActivity.class.getSimpleName();
    private TextView mDisplay;

    private static final ArrayList<String> mLifecycleCallbacks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        mDisplay = findViewById(R.id.display_text);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("onSaveInstance")) {
                String retriveContent = savedInstanceState.getString("onSaveInstance");
                mDisplay.setText(retriveContent);
            }

        }

        for (int i = mLifecycleCallbacks.size() - 1; i >= 0; i--) {
            mDisplay.append(mLifecycleCallbacks.get(i) + "\n");
        }

        mLifecycleCallbacks.clear();

        mDisplay.append("onCreate" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDisplay.append("onStart" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        mDisplay.append("onResume" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDisplay.append("onPause" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLifecycleCallbacks.add(0, "onStop");
        mDisplay.append("onStop" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mDisplay.append("onRestart" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleCallbacks.add(0, "onDestroy");
        mDisplay.append("onDestroy" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mDisplay.append("onSaveInstanceState" + "\n");
        Log.d(TAG, "Lifecycle Event: " + "onSaveInstanceState");
        String DispalyContents = mDisplay.getText().toString();
        outState.putString("onSaveInstance", DispalyContents);
    }
}
