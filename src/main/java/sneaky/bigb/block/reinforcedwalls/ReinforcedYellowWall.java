package sneaky.bigb.block.reinforcedwalls;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class ReinforcedYellowWall extends Block
{
	/**
	 * This is the constructor for the ReinforcedYellowWall class.
	 */
	public ReinforcedYellowWall()
	{
		super(Material.iron);
		this.stepSound = Block.soundTypeMetal;
		this.blockHardness = 75F;
		this.blockResistance = 75F;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("ReinforcedYellowWall");
		
		switch (ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":ReinforcedYellowWall16";
			break;
		case 2:
			this.textureName = Reference.MODID + ":ReinforcedYellowWall32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":ReinforcedYellowWall64";
			break;
		}
	}
}
