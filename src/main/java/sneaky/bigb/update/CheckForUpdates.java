package sneaky.bigb.update;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import sneaky.bigb.chat.ChatUtil;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Reference;
import sneaky.bigb.main.Util;

public class CheckForUpdates implements Runnable
{
	public static boolean isLatestVersion = false;
	public static int latestVersion;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() 
	{
		InputStream in = null;
		try 
		{
			in = new URL("https://raw.githubusercontent.com/SneakyTactician/BIGB/master/Update").openStream();
			LogHelper.ErrorAlways("URLUPDATEINFO:" + IOUtils.toString(in));
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		try 
		{
			latestVersion = this.GetNumberFromString((IOUtils.toString(in)));
			LogHelper.ErrorAlways("URLAFTERPROCESSING:" + String.valueOf(latestVersion));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			IOUtils.closeQuietly(in);
		}
		System.out.println("Latest mod version = " + latestVersion);
		
		if (Reference.Build < latestVersion)
		{
			List<EntityPlayer> entities = Util.world.playerEntities;
			int BuildsOutOfDate = latestVersion - Reference.Build;
			
			int i = 0;
			
			while (i != entities.size())
			{
				EntityPlayer a = entities.get(i);
				String message = "Hey " + a.getDisplayName() + "! Your version of BIGB is "  + BuildsOutOfDate + " builds out of date";
				ChatUtil.SendChatMessageToPlayer(message, a);
				i++;
			}
		}
		else
		{
			List<EntityPlayer> entities = Util.world.playerEntities;
			
			String message = "Your BIGB is up to date!";
			int i = 0;
			
			while (i != entities.size())
			{
				EntityPlayer a = entities.get(i);
				ChatUtil.SendChatMessageToPlayer(message, a);
				i++;
			}
		}
	}
	
	/**
	 * Used by the update checker
	 */
	public int GetNumberFromString(String str)
	{
		if (str == null)
		{
			LogHelper.ErrorAlways("Houston, we have a NullPointerException");
		}
		else
		{
			int i = 0;
			String temp = new String();
			
			while (i != str.length())
			{
				if (str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9')
				{
					temp = new String(temp + str.charAt(i));
				}
				i++;
			}
			try
			{
				return Integer.parseInt(temp);
			}
			catch (Exception e)
			{
				LogHelper.ErrorAlways(e.getCause().toString());
				e.printStackTrace();
			}
		}
		
		return 0;
	}
}
