package sneaky.bigb.block.reinforcedwalls;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class ReinforcedLimeGreenWall extends Block
{
	/**
	 * This is the constructor for the ReinforcedLimeGreenWall class.
	 */
	public ReinforcedLimeGreenWall()
	{
		super(Material.iron);
		this.stepSound = Block.soundTypeMetal;
		this.blockHardness = 75F;
		this.blockResistance = 75F;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("ReinforcedLimeGreenWall");
		
		switch (ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":ReinforcedLimeGreenWall16";
			break;
		case 2:
			this.textureName = Reference.MODID + ":ReinforcedLimeGreenWall32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":ReinforcedLimeGreenWall64";
			break;
		}
	}
}