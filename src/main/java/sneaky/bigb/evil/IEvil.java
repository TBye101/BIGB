package sneaky.bigb.evil;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import sneaky.bigb.main.Util;

/**
 * @author SneakyTactician
 * This is a base class for all evil blocks.
 */
public class IEvil extends Block
{
	
	@SideOnly(Side.CLIENT)
	public static IIcon Top;
	
	@SideOnly(Side.CLIENT)
	public static IIcon Bottom;
	
	@SideOnly(Side.CLIENT)
	public static IIcon Left;
	
	@SideOnly(Side.CLIENT)
	public static IIcon Right;
	
	@SideOnly(Side.CLIENT)
	public static IIcon Front;
	
	@SideOnly(Side.CLIENT)
	public static IIcon Back;
	
	public IEvil(Material material)
	{
		super(material);
	}
	
	/**
	 * @param ToMimic
	 * This will set all textures for the current IEvil block to mimic the block that was passed in.
	 */
	public static void SetTextures(Block ToMimic)
	{
		Bottom = ToMimic.getBlockTextureFromSide(0);
		Top = ToMimic.getBlockTextureFromSide(1);
		Front = ToMimic.getBlockTextureFromSide(2);
		Back = ToMimic.getBlockTextureFromSide(3);
		Left = ToMimic.getBlockTextureFromSide(4);
		Right = ToMimic.getBlockTextureFromSide(5);
	}
	
	/**
	 * @param x this blocks x
	 * @param y this blocks y
	 * @param z this blocks z
	 */
	public static void InfectAdjacentBlocks(int x, int y, int z)
	{
		Block a;
		
		a = Util.GetBlockFromCoord(x + 1, y, z);
		if (a.getUnlocalizedName().substring(5, 9).toLowerCase() != "evil")
		{
			AttemptToInfect(a, x + 1, y, z);
		}
		
		a = Util.GetBlockFromCoord(x - 1, y, z);
		if (a.getUnlocalizedName().substring(5, 9).toLowerCase() != "evil")
		{
			AttemptToInfect(a, x - 1, y, z);
		}
		
		a = Util.GetBlockFromCoord(x, y + 1, z);
		if (a.getUnlocalizedName().substring(5, 9).toLowerCase() != "evil")
		{
			AttemptToInfect(a, x, y + 1, z);
		}
		
		a = Util.GetBlockFromCoord(x, y - 1, z);
		if (a.getUnlocalizedName().substring(5, 9).toLowerCase() != "evil")
		{
			AttemptToInfect(a, x, y - 1, z);
		}
	}
	
	public static void AttemptToInfect(Block block, int x, int y, int z)
	{
		if (block.isAir(Util.world, x, y, z))
		{
			return;
		}
		else
		{
			Random a;
			a = new Random();
			if (a.nextInt(10) > 4)
			{
				ActuallyInfect(block, x, y, z);
			}
		}
	}
	
	public static void ActuallyInfect(Block block, int x, int y, int z)
	{
		if (block.getUnlocalizedName().substring(5).toLowerCase() == "dirt")
		{
			block.breakBlock(Util.world, x, y, z, block, 0);
			Util.world.setBlock(x, y, z, new EvilDirt());
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
			switch (side)
			{
			case 0:
				//Bottom
				return Bottom;
			case 1:
				//Top
				return Top;
			case 2:
				//front
				return Front;
			case 3:
				//back
				return Back;
			case 4:
				//left
				return Left;
			case 5:
				//right
				return Right;
			}
			return Front;
	}
	
	
}