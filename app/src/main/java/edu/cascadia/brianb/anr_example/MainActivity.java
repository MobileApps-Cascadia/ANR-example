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
        //Button click to sleep the UI thread
        //Continue clicking on the app while "hung" to see the ANR message

        final SeekBar secondsSeek = findViewById(R.id.sleepMeSeek);
        final TextView displayDelay = findViewById(R.id.displayDelay);
        final Button stallButton = findViewById(R.id.stallButton);

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
        stallButton.setOnClickListener(view -> {
            new Thread(new Runnable() {
                public void run() {
                    view.post(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(secondsSeek.getProgress() * 1000); // sleep for some seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }).start();
        });
    }
}
