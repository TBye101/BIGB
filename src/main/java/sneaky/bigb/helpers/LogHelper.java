package sneaky.bigb.helpers;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;

public class LogHelper
{
	/**
	 * Outputs a message to the console sometimes, depending on config settings.
	 */
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
	
	private static void LogAlways(Level logLevel, Object object)
	{
		FMLLog.log(Reference.NAME, logLevel, String.valueOf(object));
	}
	
    /**
     * Outputs a message to the console, that is tagged as an error.
     */
    public static void error(Object object)
    {
    	log(Level.ERROR, object);
    } 
    
    /**
     * Sometimes outputs a message to the console, that is tagged as fatal.
     */
    public static void fatal(Object object)
    {
    	log(Level.FATAL, object);
    }
    
    /**
     * Sometimes outputs a message to the console, that is tagged as info.
     */
    public static void info(Object object)
    {
    	log(Level.INFO, object);
    }
    
    /**
     * Sometimes outputs a message to the console, that is tagged as a warning.
     */
    public static void warn(Object object)
    {
    	log(Level.WARN, object);
    }
    
    /**
     * Outputs a message to the console no matter what, that is tagged as an error.
     */
    public static void ErrorAlways(Object object)
    {
    	LogAlways(Level.ERROR, object);
    }
    
    /**
     * Outputs a message to the console no matter what, that is tagged as fatal.
     */
    public static void FatalAlways(Object object)
    {
    	LogAlways(Level.FATAL, object);
    }
    
    /**
     * Outputs a message to the console no matter what, that is tagged as info.
     */
    public static void InfoAlways(Object object)
    {
    	LogAlways(Level.INFO, object);
    }
    
    /**
     * Outputs a message to the console no matter what, that is tagged as a warning.
     */
    public static void WarnAlways(Object object)
    {
    	LogAlways(Level.WARN, object);
    }
}
