package com.example.cake2;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, View.OnTouchListener,
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    private final CakeView view;
    private final CakeModel model;

    public CakeController(CakeView view) {
        this.view = view;
        this.model = view.getModel();
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            model.candlesAreLit = !model.candlesAreLit;
            view.invalidate();

            Button button = (Button) v;
            if (model.candlesAreLit) {
                button.setText("extinguish");
            } else {
                button.setText("Re-light");
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.candleSwitch) {
            model.cakeCandles = isChecked;
        } else {
            model.cakeFrosting = isChecked;
        }

        view.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        model.candlesOnCake = progress;
        view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //empty
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //empty
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v.performClick();
        model.x = event.getX();
        model.y = event.getY();
        view.invalidate();

        return true;
    }
}
