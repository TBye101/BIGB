package nonmc;

import javax.swing.JOptionPane;

public class NonMCEntrance
{

	public static void main(String[] args)
	{
		MessageBox("Hey silly, this is a Minecraft mod. NOT a normal executible jar.", "Don't Click Me");
	}
	
    public static void MessageBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}