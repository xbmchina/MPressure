package com.zero.mp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("pressure");
    }

    private MprocessBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb= (MprocessBar) findViewById(R.id.pb);

    }

    public native void startMoniter();

    public native void stopMoniter();

    public void start(View view){
        new Thread(){
            public void run() {
                startMoniter();
            };
        }.start();

    }
    public void stop(View view){
        stopMoniter();
    }

    public void setPressure(int pressure ){
        //pb.setProgress(pressure);
        pb.setPressure(pressure);
    }
}
