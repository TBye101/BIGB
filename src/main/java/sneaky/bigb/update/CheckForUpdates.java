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
			byte[] b;
			b = new byte[3];
			
			in.read(b);
			latestVersion = IOUtils.toString(b);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			IOUtils.closeQuietly(in);
		}
		

		
		System.out.println("Latest " + Reference.BIGBSPELLING + " version = " + latestVersion);
		System.out.println("You are running " + Reference.BIGBSPELLING + " version: " + Reference.Build);
		String message = "Latest " + Reference.BIGBSPELLING + " version = " + latestVersion;
		String message2 = "You are running " + Reference.BIGBSPELLING + " version: " + Reference.Build;
		ChatUtil.SendChatMessageToPlayer(message, player);
		ChatUtil.SendChatMessageToPlayer(message2, player);
		IOUtils.closeQuietly(in);
	}
}