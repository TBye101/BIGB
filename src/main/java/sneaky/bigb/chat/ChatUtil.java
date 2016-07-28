package sneaky.bigb.chat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatUtil
{
	public static void SendChatMessageToPlayer(String message, EntityPlayer player)
	{
		IChatComponent Chatmessage = new ChatComponentText(message);
		player.addChatComponentMessage(Chatmessage);
	}
	
	public static void AddBlackString(String car, String str)
	{
		str = str + "\u00A70";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkBlueString(String car, String str)
	{
		str = str + "\u00A71";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkGreenString(String car, String str)
	{
		str = str + "\u00A72";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkAquaString(String car, String str)
	{
		str = str + "\u00A73";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkRedString(String car, String str)
	{
		str = str + "\u00A74";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkPurpleString(String car, String str)
	{
		str = str + "\u00A75";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddGoldString(String car, String str)
	{
		str = str + "\u00A76";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddGrayString(String car, String str)
	{
		str = str + "\u00A77";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddDarkGreyString(String car, String str)
	{
		str = str + "\u00A78";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddBlueString(String car, String str)
	{
		str = str + "\u00A79";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddGreenString(String car, String str)
	{
		str = str + "\u00A7a";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddAquaString(String car, String str)
	{
		str = str + "\u00A7b";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddRedString(String car, String str)
	{
		str = str + "\u00A7c";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddLightPurpleString(String car, String str)
	{
		str = str + "\u00A7d";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddYellowString(String car, String str)
	{
		str = str + "\u00A7e";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddWhiteString(String car, String str)
	{
		str = str + "\u00A7f";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddObfuscatedString(String car, String str)
	{
		str = str + "\u00A7k";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddBoldString(String car, String str)
	{
		str = str + "\u00A7l";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddStrikeThroughString(String car, String str)
	{
		str = str + "\u00A7m";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddUnderlineString(String car, String str)
	{
		str = str + "\u00A7n";
		str = str + car;
		str = str + "\u00A7r";
	}
	
	public static void AddItalicString(String car, String str)
	{
		str = str + "\u00A7o";
		str = str + car;
		str = str + "\u00A7r";
	}
}
