package com.example.cake2;

import android.content.pm.ActivityInfo;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.example.cake2.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView view = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(view);
        view.setOnTouchListener(controller);

        Button blowOut = findViewById(R.id.blowOutButton);
        blowOut.setOnClickListener(controller);

        CompoundButton candleSwitch = findViewById(R.id.candleSwitch);
        candleSwitch.setOnCheckedChangeListener(controller);

        CompoundButton frostingSwitch = findViewById(R.id.frostingSwitch);
        frostingSwitch.setOnCheckedChangeListener(controller);

        SeekBar candleSeek = findViewById(R.id.candleSeek);
        candleSeek.setOnSeekBarChangeListener(controller);


    }

    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }
}
