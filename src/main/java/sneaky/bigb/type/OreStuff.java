package sneaky.bigb.type;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

/**
 * @author SneakyTactician
 * Holds various stuff that are created automatically for an ore;
 */
public class OreStuff
{
	
	public OreStuff()
	{
		
	}
	
	public String BaseName;
	
	/**
	 * The pickaxe for this ore.
	 */
	public ItemPickaxe Pickaxe;
	public boolean HasPickaxe = false;
	
	/**
	 * The shovel for this ore.
	 */
	public ItemSpade Shovel;
	public boolean HasShovel = false;
	
	/**
	 * The hoe for this ore.
	 */
	public ItemHoe Hoe;
	public boolean HasHoe = false;
	
	
	/**
	 * The sword for this ore.
	 */
	public ItemSword Sword;
	public boolean HasSword = false;
	
	/**
	 * The axe for this ore.
	 */
	public ItemAxe Axe;
	public boolean HasAxe = false;
	
	
	/**
	 * The actual ore block.
	 */
	public Block OreBlock;
	public boolean HasOreBlock = false;
	
	/**
	 * The metal block for this ore.
	 */
	public Block MetalBlock;
	public boolean HasMetalBlock = false;
	
	/**
	 * The ingot for this ore.
	 */
	public Item MetalIngot;
	public boolean HasMetalIngot = false;
	
	/**
	 * The nugget for this ore.
	 */
	public Item MetalNugget;
	public boolean HasMetalNugget = false;
	
	/**
	 * The material for this ore.
	 */
	public ToolMaterial MetalMaterial;
	public boolean HasMetalMaterial = false;
}