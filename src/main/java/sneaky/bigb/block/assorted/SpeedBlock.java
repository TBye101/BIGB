package sneaky.bigb.block.assorted;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.main.Reference;
import sneaky.bigb.tabs.ModTabs;

/**
 * @author SneakyTactician
 * The speed block class is a block that increases the speed of the entity walking on it.
 */
public class SpeedBlock extends Block
{

	/**
	 * The constructor for the SpeedBlock class.
	 */
	public SpeedBlock()
	{	
		super(Material.rock);
		this.blockHardness = 15;
		this.blockResistance = 25;
		this.enableStats = false;
		this.lightOpacity = 10;
		this.lightValue = 7;
		this.setCreativeTab(ModTabs.maintab);
		this.setBlockName("Speed Block");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeStone);
		this.SetTexture();
	}
	
	//makes the player walk faster while walking on speedblocks.
	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#onEntityWalking(net.minecraft.world.World, int, int, int, net.minecraft.entity.Entity)
	 */
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (entity.motionX < 1 && entity.motionZ < 1)
		{
			double xv = entity.motionX;
			double zv = entity.motionZ;
			
			xv *= 5;
			zv *= 5;
			
			entity.addVelocity(xv, 0, zv);
		}
	}
	
	public void SetTexture()
	{
		switch(ModConfig.TextureLevel())
		{
		case 1:
			this.textureName = Reference.MODID + ":SpeedBlock";
			break;
		case 2:
			this.textureName = Reference.MODID + ":SpeedBlock32";
			break;
		case 3:
			this.textureName = Reference.MODID + ":SpeedBlock64";
			break;
		default:
			this.textureName = Reference.MODID + ":SpeedBlock64";
			break;
		}
	}
}