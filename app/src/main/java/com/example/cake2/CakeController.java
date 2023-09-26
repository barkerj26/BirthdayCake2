package com.example.cake2;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private CakeView view;
    private CakeModel model;

    public CakeController(CakeView view) {
        this.view = view;
        this.model = view.getModel();
    }

    @Override
    public void onClick(View v) {
        model.candlesAreLit = !model.candlesAreLit;
        view.invalidate();

        if (v instanceof Button) {
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
    public boolean onTouch(View v, MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_UP){
            //figure out where they clicked


            //add checker

            //update view

            //return consumed
            return true;
        }
        return false;
    }
}
