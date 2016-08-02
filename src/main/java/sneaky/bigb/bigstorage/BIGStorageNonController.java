package sneaky.bigb.bigstorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import sneaky.bigb.bigstorage.controllers.BIGStorageController;
import sneaky.bigb.chat.ChatUtil;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.main.Util;
import sneaky.bigb.type.Point;

/**
 * @author SneakyTactician
 * Used to store variables that every BIGStorageBlock should have.
 */
public class BIGStorageNonController extends Block
{
	public Point OurLocation;
	
	public boolean Connected = false;
	
	public BIGStorageController TheController;
	
	/**
	 * This tells us how many different kinds of blocks can be stored by a module.
	 */
	public int DifferentBlocksThisCanStore = 0;

	/**
	 * The constructor for the BIGStorageBlock class.
	 */
	public BIGStorageNonController(Material material)
	{
		super(material);
	}
	
	/**
	 * Figures out if this block is touching the controller, or touching a block that has an instance of it.
	 */
	public boolean AreWeConnected()
	{
		Block One;
		Block Two;
		Block Three;
		Block Four;
		Block Five;
		Block Six;
		
		if (Util.world == null)
		{
			LogHelper.ErrorAlways("WORLD IS STINKIN NULL AGAIN!");
		}
		
		One = Util.world.getBlock(OurLocation.x + 1, OurLocation.y, OurLocation.z);
		Two = Util.world.getBlock(OurLocation.x - 1, OurLocation.y, OurLocation.z);
		Three = Util.world.getBlock(OurLocation.x, OurLocation.y + 1, OurLocation.z);
		Four = Util.world.getBlock(OurLocation.x, OurLocation.y - 1, OurLocation.z);
		Five = Util.world.getBlock(OurLocation.x, OurLocation.y, OurLocation.z + 1);
		Six = Util.world.getBlock(OurLocation.x, OurLocation.y, OurLocation.z - 1);
		
		if (BIGStorageUtil.IsBIGStorage(One) || BIGStorageUtil.IsBIGStorage(Two) || BIGStorageUtil.IsBIGStorage(Three) || BIGStorageUtil.IsBIGStorage(Four) || BIGStorageUtil.IsBIGStorage(Five) || BIGStorageUtil.IsBIGStorage(Six))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This should only be called if one of these blocks is the controller or has an object of it. Gets the controller.
	 */
	public BIGStorageController GetController()
	{
		Block One;
		Block Two;
		Block Three;
		Block Four;
		Block Five;
		Block Six;
		
		One = Util.world.getBlock(OurLocation.x + 1, OurLocation.y, OurLocation.z);
		Two = Util.world.getBlock(OurLocation.x - 1, OurLocation.y, OurLocation.z);
		Three = Util.world.getBlock(OurLocation.x, OurLocation.y + 1, OurLocation.z);
		Four = Util.world.getBlock(OurLocation.x, OurLocation.y - 1, OurLocation.z);
		Five = Util.world.getBlock(OurLocation.x, OurLocation.y, OurLocation.z + 1);
		Six = Util.world.getBlock(OurLocation.x, OurLocation.y, OurLocation.z - 1);
		
		if (BIGStorageUtil.IsBIGStorage(One))
		{
			BIGStorageNonController block = (BIGStorageNonController) One;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(One))
		{
			BIGStorageController a = (BIGStorageController) One;
			return a;
		}
		
		if (BIGStorageUtil.IsBIGStorage(Two))
		{
			BIGStorageNonController block = (BIGStorageNonController) Two;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(Two))
		{
			BIGStorageController a = (BIGStorageController) Two;
			return a;
		}
		
		if (BIGStorageUtil.IsBIGStorage(Three))
		{
			BIGStorageNonController block = (BIGStorageNonController) Three;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(Three))
		{
			BIGStorageController a = (BIGStorageController) Three;
			return a;
		}
		
		if (BIGStorageUtil.IsBIGStorage(Four))
		{
			BIGStorageNonController block = (BIGStorageNonController) Four;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(Four))
		{
			BIGStorageController a = (BIGStorageController) Four;
			return a;
		}
		
		if (BIGStorageUtil.IsBIGStorage(Five))
		{
			BIGStorageNonController block = (BIGStorageNonController) Five;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(Five))
		{
			BIGStorageController a = (BIGStorageController) Five;
			return a;
		}
		
		if (BIGStorageUtil.IsBIGStorage(Six))
		{
			BIGStorageNonController block = (BIGStorageNonController) Six;
			return block.TheController;
		}
		
		if (BIGStorageUtil.IsController(Six))
		{
			BIGStorageController a = (BIGStorageController) Six;
			return a;
		}
		
		return null;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		OurLocation = new Point(x, y, z);
		
		if (this.AreWeConnected())
		{
			ChatUtil.SendChatMessageToAllPlayers("We are connected!");
			LogHelper.InfoAlways("We are connected");
			this.TheController = this.GetController();
			if (this.TheController != null)
			{
				ChatUtil.SendChatMessageToAllPlayers("Got it!");
				LogHelper.InfoAlways("Got it!");
			}
			else
			{
				ChatUtil.SendChatMessageToAllPlayers("Controller is null!");
				LogHelper.InfoAlways("Controller is null!");
			}
		}
		else
		{
			ChatUtil.SendChatMessageToAllPlayers("Not Connected!");
			LogHelper.InfoAlways("Not Connected!");
		}
	}

}