package edu.cascadia.brianb.anr_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button click to sleep the UI thread
        //Continue clicking on the app while "hung" to see the ANR message
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                SleepAMinute();
            }
        });

    }
    private static void SleepAMinute() {
        try {
            Thread.sleep(20 * 1000); // sleep for 20 seconds
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
