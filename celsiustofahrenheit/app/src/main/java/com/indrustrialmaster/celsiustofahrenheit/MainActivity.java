package com.indrustrialmaster.celsiustofahrenheit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView3,textView4;
    SeekBar seekBar2;
    double c,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView4=(TextView) findViewById(R.id.textView4);
        textView3=(TextView) findViewById(R.id.textView3);
        textView3.setTextSize(20);
        textView4.setTextSize(20);

        seekBar2=(SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setMax(400);
        seekBar2.setProgress(200);
        c=seekBar2.getProgress()-200;
        f=c*1.8+32;
        textView4.setText(String.format(Locale.getDefault(), "%.2f °C",c));
        textView3.setText(String.format(Locale.getDefault(), "%.2f °F",f));
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                c=progress-200;
                f=c*1.8+32;
                textView4.setText(String.format(Locale.getDefault(), "%.2f °C",c));
                textView3.setText(String.format(Locale.getDefault(), "%.2f °F",f));
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
