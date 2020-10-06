package com.justcris;

import javax.swing.*;

public class Timer extends Thread {

    private long _cent;
    private long _sec;
    private long _min;
    private final JLabel _lbl;
    private boolean _stopped;

    public Timer(long _min, long _sec, long _cent, JLabel _lbl) {
        if (_sec < 0) _sec *= -1;
        if (_cent < 0) _cent *= -1;
        if (_min < 0) _min *= -1;

        if (_sec > 59) _sec = 59;
        if (_cent > 99) _cent = 99;
        this._cent = _cent;
        this._sec = _sec;
        this._min = _min;
        this._lbl = _lbl;
        _stopped = false;
    }

    @Override
    public void run() {


        while (!_stopped && !(this._min == 0 && this._sec == 0 && this._cent == 0)) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this._cent--;
            if (this._cent == -1) {
                this._cent = 99;
                this._sec--;
                if (this._sec == -1) {
                    this._sec = 59;
                    this._min--;
                }
            }

            _lbl.setText(_min + " : " + _sec + " : " + _cent);

        }

       if(this._min == 0 && this._sec == 0 && this._cent == 0){
           JOptionPane.showMessageDialog(null, "Time's up!");
       }


    }

    public long get_cent() {
        return _cent;
    }

    public long get_sec() {
        return _sec;
    }

    public long get_min() {
        return _min;
    }

    public String get_time(){
       return _min + " : " + _sec + " : " + _cent;
    }



    public void stop_counter(){
        _stopped = true;
    }

    public void free_counter(){
        _stopped = false;
    }

}
