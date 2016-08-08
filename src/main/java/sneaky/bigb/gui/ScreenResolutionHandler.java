package sneaky.bigb.gui;

import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * Holds some logic and data that helps the GUI render things right for various screen resolutions.
 */
public class ScreenResolutionHandler
{
	/**
	 * Helps the access unit to draw the player inventory hotbar correctly.
	 */
	public static int GetYValueForAccessUnitContainerHotBars()
	{
		LogHelper.ErrorAlways("Screen Height = " + GUIUtils.GetSHeight());
		
		//Heights to support: 1387, 1080, 1200, 1440, 480
		
		switch (GUIUtils.GetSHeight())
		{
		case 480:
			return 167;//Done
		case 1080:
			return (GUIUtils.GetSHeight() / 3) + 7;
		case 1200:
			return (GUIUtils.GetSHeight() / 3) + 7;
		case 1387:
			return 159;
		case 1440:
			return 179; //done
			default:
				return (GUIUtils.GetSHeight() / 3) + GUIUtils.GetSHeight() / 50;
		}
	}
}