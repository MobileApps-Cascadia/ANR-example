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

        final SeekBar secondsSeek = findViewById(R.id.sleepMeSeek);
        final TextView displayDelay = findViewById(R.id.displayDelay);
        final Button stallButton = findViewById(R.id.stallButton);

        //Handles SeekBar update
        secondsSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displayDelay.setText(getString(R.string.delayDisplay, progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //Handles Button click
        stallButton.setOnClickListener(view -> {
            new Thread(() -> {
                try {
                    Thread.sleep(secondsSeek.getProgress() * 1000); // sleep for some seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
