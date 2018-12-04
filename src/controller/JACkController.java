package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;

import model.JACkModel;
import view.JACkView;

public class JACkController {
    private JACkView view;
    private JACkModel model;
    private static int format;
    private Timer controlTimer;

    public JACkController(JACkModel theModel, JACkView theView) {
        format = 1;
        view = theView;
        model = theModel;
        this.controlTimer = new Timer();
        this.updateTime();
    }

    private JACkView getView() {
		return view;
	}

	private void setView(JACkView view) {
		this.view = view;
	}

	private JACkModel getModel() {
		return model;
	}

	private void setModel(JACkModel model) {
		this.model = model;
	}

	private int getFormat() {
		return format;
	}

	public static void setFormat(int f) {
		format = f;
	}

	private Timer getControlTimer() {
		return controlTimer;
	}

	private void setControlTimer(Timer controlTimer) {
		this.controlTimer = controlTimer;
	}

	public void updateTime() {
        controlTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                model.getClock().now();
                if(format==1) {
                    view.displayTime(model.getClock().toStringWithSeconds());
                    System.out.println(model.getClock().toStringWithSeconds());
                }
                else if(format == 2) {
                    view.displayTime(model.getClock().toString());
                    System.out.println(model.getClock().toString());
                }
                else if(format == 3) {
                    view.displayTime(model.getClock().toStringEnglish());
                    System.out.println(model.getClock().toStringEnglish());
                }
            }
        }, 0, 1000);
    }
    
    public class ShowSecondListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		AbstractButton second = (AbstractButton) e.getSource();
    		boolean selected = second.getModel().isSelected();
    		if(selected) {
    			JACkController.setFormat(1);
    		}
    		else
    			JACkController.setFormat(2);
    	}

    }
}