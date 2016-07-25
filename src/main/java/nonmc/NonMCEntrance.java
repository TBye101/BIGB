package nonmc;

import javax.swing.JOptionPane;

public class NonMCEntrance
{
	
    public static void MessageBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args)
    {
    	run();
    }
    //- See more at: http://www.wuppy29.com/minecraft/java-tutorials/java-hello-world-about-eclipse-and-java/#sthash.t4s7CNqM.dpuf

	public static void run()
	{
		MessageBox("Hey silly, this is a Minecraft mod. NOT a normal executible jar.", "Don't Click Me");
	}
}