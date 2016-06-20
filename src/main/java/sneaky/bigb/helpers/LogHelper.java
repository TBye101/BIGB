package sneaky.bigb.helpers;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;

public class LogHelper
{
	private static void log(Level logLevel, Object object)
	{
		if (Reference.IsConfigLoaded)
		{
			if (!ModConfig.DisableAllLoggingAfterConfigIsLoaded())
			{
				FMLLog.log(Reference.NAME, logLevel, String.valueOf(object));
			}
		}
		else
		{
			FMLLog.log(Reference.NAME, logLevel, String.valueOf(object));
		}
	} 
    public static void error(Object object)
    {
    	log(Level.ERROR, object);
    } 
    public static void fatal(Object object)
    {
    	log(Level.FATAL, object);
    } 
    public static void info(Object object)
    {
    	log(Level.INFO, object);
    } 
    public static void warn(Object object)
    {
    	log(Level.WARN, object);
    }
}
