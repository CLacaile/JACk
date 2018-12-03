package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.JACkModel;
import view.JACkView;

public class JACkController {
    private JACkView view;
    private JACkModel model;
    private int format;
    private Timer controlTimer;

    public JACkController(JACkModel theModel, JACkView theView) {
        format = 1;
        view = theView;
        model = theModel;
        this.controlTimer = new Timer();
        this.updateTime();
    }

    public void updateTime() {
        controlTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                model.getClock().now();
                if(format==1) {
                    view.displayTime(model.getClock().toStringWithSeconds());
                }
                else if(format == 2) {
                    view.displayTime(model.getClock().toString());
                }
            }
        }, 0, 1000);

    }
}
