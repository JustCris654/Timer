package com.justcris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter {
    private JPanel panelMain;
    private JLabel lbl_image;
    private JButton btn_stop;
    private JButton btn_savetime;
    private JButton btn_start;
    private JLabel lbl_showtime;
    private JLabel lbl_savedTime;
    private Timer timer;
    private boolean busy_timer;


    public Counter() {

        lbl_showtime.setText("10 : 00 : 00");
        busy_timer = false;


        btn_start.addActionListener(e -> {
            if(!busy_timer){
                busy_timer = true;
            } else {
                timer.stop_counter();
            }
            timer = new Timer(10, 0, 0, lbl_showtime);
            timer.start();
        });
        btn_stop.addActionListener(e -> {
            timer.stop_counter();
            busy_timer = false;
        });
        btn_savetime.addActionListener(e -> lbl_savedTime.setText(timer.get_time()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cronometro");
        frame.setContentPane(new Counter().panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
