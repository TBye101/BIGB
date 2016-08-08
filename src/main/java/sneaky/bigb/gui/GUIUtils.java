package sneaky.bigb.gui;

import net.minecraft.client.Minecraft;

/**
 * @author SneakyTactician
 * A class with a few GUI utilities.
 */
public class GUIUtils
{
    private static Minecraft mc = Minecraft.getMinecraft();
	
    /**
     * Gets the height of the screen.
     */
    public static int GetSHeight()
    {
    	return mc.displayHeight;
    }
    
    /**
     * Gets the width of the screen.
     */
    public static int GetSWidth()
    {
    	return mc.displayWidth;
    }
}