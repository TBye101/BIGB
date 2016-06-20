package sneaky.bigb.block.reinforcedwalls;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class ReinforcedDarkBlueWall extends Block
{
	/**
	 * This is the constructor for the ReinforcedDarkBlueWall class.
	 */
	public ReinforcedDarkBlueWall()
	{
		super(Material.iron);
		this.stepSound = Block.soundTypeMetal;
		this.blockHardness = 75F;
		this.blockResistance = 75F;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("ReinforcedDarkBlueWall");
		
		switch (ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":ReinforcedDarkBlueWall16";
			break;
		case 2:
			this.textureName = Reference.MODID + ":ReinforcedDarkBlueWall32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":ReinforcedDarkBlueWall64";
			break;
		}
	}
}
