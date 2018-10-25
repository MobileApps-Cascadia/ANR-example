package edu.cascadia.brianb.anr_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button click to sleep the UI thread
        //Continue clicking on the app while "hung" to see the ANR message

        final SeekBar secondsSeek = (SeekBar)findViewById(R.id.sleepMeSeek);
        findViewById(R.id.stopButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                SleepAwhile(secondsSeek.getProgress());
            }
        });

    }
    private static void SleepAwhile(int sec) {
        try {
            Thread.sleep(sec * 1000); // sleep for 2 seconds
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
