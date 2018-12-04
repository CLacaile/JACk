package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.*;

import controller.JACkController;

@SuppressWarnings("serial")
public class ClockBar extends JMenuBar
{
	private JMenu viewMenu = new JMenu("Vue");
	private JMenu clockType = new JMenu("Clock");
	private JMenu optionsMenu = new JMenu("Options");
	private JMenu formatMenu = new JMenu("Format");
    private JMenuItem clock1 = new JMenuItem("Clock1");
	private JMenuItem clock2 = new JMenuItem("Clock2");
	private JMenuItem clock3 = new JMenuItem("Clock3");
	private JMenuItem formatAMPM = new JMenuItem("AM/PM");
	private JMenuItem format24h = new JMenuItem("24h");
	private JCheckBoxMenuItem secondes = new JCheckBoxMenuItem("Secondes");

	public ClockBar() {
		class EnglishFormatListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==formatAMPM) {
					JACkController.setFormat(3);
    				secondes.setVisible(false);
				}
			}
		}
		formatAMPM.addActionListener(new EnglishFormatListener());
		formatMenu.add(formatAMPM);
		
		class ClassicFormatListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==format24h) {
					if(secondes.isSelected())
						JACkController.setFormat(1);
					else
						JACkController.setFormat(2);
    				secondes.setVisible(true);
				}
			}
		}
		format24h.addActionListener(new ClassicFormatListener());
		formatMenu.add(format24h);
		
		viewMenu.add(formatMenu);
		viewMenu.addSeparator();

		clockType.add(clock1);
		clockType.add(clock2);
		clockType.add(clock3);
		viewMenu.add(clockType);
		viewMenu.addSeparator();
		
		secondes.setSelected(true);
		
		class ShowSecondListener implements ActionListener {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		AbstractButton second = (AbstractButton) e.getSource();
	    		boolean selected = second.getModel().isSelected();
	    		if(selected) {
	    			JACkController.setFormat(1);
	    		}
	    		else {
	    			JACkController.setFormat(2);
	    		}
	    	}
		}
	    secondes.addActionListener(new ShowSecondListener());
		viewMenu.add(secondes);
		
		this.add(viewMenu);
		
		this.add(optionsMenu);
		
		this.setVisible(true);
	}
}