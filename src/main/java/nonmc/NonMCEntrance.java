package nonmc;

import javax.swing.JOptionPane;

public class NonMCEntrance implements Runnable
{
	
    public static void MessageBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

	@Override
	public void run()
	{
		MessageBox("Hey silly, this is a Minecraft mod. NOT a normal executible jar.", "Don't Click Me");
	}
}