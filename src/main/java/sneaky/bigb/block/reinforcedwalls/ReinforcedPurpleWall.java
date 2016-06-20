package sneaky.bigb.block.reinforcedwalls;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

public class ReinforcedPurpleWall extends Block
{
	/**
	 * This is the constructor for the ReinforcedPurpleWall class.
	 */
	public ReinforcedPurpleWall()
	{
		super(Material.iron);
		this.stepSound = Block.soundTypeMetal;
		this.blockHardness = 75F;
		this.blockResistance = 75F;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("ReinforcedPurpleWall");
		
		switch (ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":ReinforcedPurpleWall16";
			break;
		case 2:
			this.textureName = Reference.MODID + ":ReinforcedPurpleWall32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":ReinforcedPurpleWall64";
			break;
		}
	}
}
