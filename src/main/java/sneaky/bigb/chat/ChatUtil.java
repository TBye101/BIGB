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
}
