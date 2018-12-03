package view;

import javax.swing.*;

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
		formatMenu.add(formatAMPM);
		formatMenu.add(format24h);
		viewMenu.add(formatMenu);

		viewMenu.add(formatMenu);
		viewMenu.addSeparator();

		clockType.add(clock1);
		clockType.add(clock2);
		clockType.add(clock3);
		viewMenu.add(clockType);
		
		viewMenu.addSeparator();
		viewMenu.add(secondes);
		
		this.add(viewMenu);
		
		this.add(optionsMenu);
		
		this.setVisible(true);
	}
}
