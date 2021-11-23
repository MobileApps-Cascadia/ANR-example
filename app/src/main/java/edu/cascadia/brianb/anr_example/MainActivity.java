package edu.cascadia.brianb.anr_example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: Click the Button to sleep the UI thread for some seconds
        //TODO: Adjust the slider then click to see how much stall it takes to cause an ANR message

        final SeekBar secondsSeek = findViewById(R.id.sleepMeSeek);
        final TextView displayDelay = findViewById(R.id.displayDelay);
        final Button stallButton = findViewById(R.id.stallButton);

        secondsSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displayDelay.setText(getString(R.string.delayDisplay,progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        stallButton.setOnClickListener( view -> SleepAwhile(secondsSeek.getProgress()));

    }
    private static void SleepAwhile(int sec) {
        try {
            Thread.sleep(sec * 1000); // sleep for some seconds

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
