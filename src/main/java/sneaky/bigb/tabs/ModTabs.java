package sneaky.bigb.tabs;

import net.minecraft.creativetab.CreativeTabs;

/**
 * @author SneakyTactician
 * This class contains all creative tab instances for this mod.
 */
public class ModTabs
{
	/**
	 * This creative tab is the main tab for the BIGB mod. Pretty much everything will be stored here.
	 */
	public static CreativeTabs maintab = new MainTab(CreativeTabs.getNextID(), "BIGB Main Tab");
}
