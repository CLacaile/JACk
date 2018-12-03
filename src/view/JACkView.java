package view;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JACkView extends JFrame {
    private ClockBar menuBar = new ClockBar();
    private TimeComponent time;
    private JPanel pan;
    private JButton bouton;
    private JLabel nowDisplay;

    public JACkView() {
        pan = new JPanel();
        bouton = new JButton();
        nowDisplay = new JLabel();

        this.setSize(300, 200);
        this.setTitle("MY BIG CLOCK");
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setLayout(new FlowLayout());


        bouton.setText("Changer le format");
        bouton.setBounds(110, 300, 160, 35);
        nowDisplay.setText("Heure:Minutes:Secondes");
        nowDisplay.setFont(new Font("Arial", 1, 60));
        //nowDisplay.setBounds(10, 10, 400, 250);
        this.getContentPane().add(nowDisplay);
        //this.getContentPane().add(bouton);


        this.setMenuBar(new MenuBar());

        this.setVisible(true);
    }

	/*public ClockBar getMenuBar() {
		return menuBar;
	}*/

    public void setMenuBar(ClockBar menuBar) {
        this.menuBar = menuBar;
    }

    public TimeComponent getTime() {
        return time;
    }

    public void setTime(TimeComponent time) {
        this.time = time;
    }

    public JPanel getPan() {
        return pan;
    }

    public void setPan(JPanel pan) {
        this.pan = pan;
    }

    public JButton getBouton() {
        return bouton;
    }

    public void setBouton(JButton bouton) {
        this.bouton = bouton;
    }

    public JLabel getNowDisplay() {
        return nowDisplay;
    }

    public void setNowDisplay(JLabel nowDisplay) {
        this.nowDisplay = nowDisplay;
    }

    public void displayTime(String time)
    {
        // Met a jour le temps sur l'affichage ?
        nowDisplay.setText(time);
    }
}
