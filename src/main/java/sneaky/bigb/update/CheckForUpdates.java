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
	public boolean isLatestVersion = false;
	public String latestVersion;
	public EntityPlayer player;

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
			latestVersion = IOUtils.toString(in);
			
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
		
		if (Reference.Build != latestVersion)
		{
				String message = "Hey " + player.getDisplayName() + "! Your version of BIGB is out of date";
				ChatUtil.SendChatMessageToPlayer(message, player);
		}
		else
		{
			String message = "Your BIGB is up to date!";
			ChatUtil.SendChatMessageToPlayer(message, player);
		}
	}
}