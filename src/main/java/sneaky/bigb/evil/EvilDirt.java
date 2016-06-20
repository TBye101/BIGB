package sneaky.bigb.evil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

/**
 * @author SneakyTactician
 * An evil version of dirt
 */
public class EvilDirt extends IEvil
{


	@SuppressWarnings("static-access")
	public EvilDirt()
	{
		super(Material.ground);
		
		this.blockHardness = 25;
		this.blockResistance = 25;
		this.setBlockName("EvilDirt");
		this.SetTextures(Blocks.dirt);
	}

}