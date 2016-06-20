package sneaky.bigb.type;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
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
	/**
	 * The pickaxe for this ore.
	 */
	public ItemPickaxe Pickaxe;
	boolean HasPickaxe = false;
	
	/**
	 * The shovel for this ore.
	 */
	public ItemSpade Shovel;
	boolean HasShovel = false;
	
	/**
	 * The hoe for this ore.
	 */
	public ItemHoe Hoe;
	boolean HasHoe = false;
	
	
	/**
	 * The sword for this ore.
	 */
	public ItemSword Sword;
	boolean HasSword = false;
	
	/**
	 * The axe for this ore.
	 */
	public ItemAxe Axe;
	boolean HasAxe = false;
	
	
	/**
	 * The actual ore block.
	 */
	public Block OreBlock;
	boolean HasOreBlock = false;
	
	/**
	 * The metal block for this ore.
	 */
	public Block MetalBlock;
	boolean HasMetalBlock = false;
	
	/**
	 * The ingot for this ore.
	 */
	public Item MetalIngot;
	boolean HasMetalIngot = false;
	
	/**
	 * The nugget for this ore.
	 */
	public Item MetalNugget;
	boolean HasMetalNugget = false;
	
	/**
	 * The material for this ore.
	 */
	public Material MetalMaterial;
	boolean HasMetalMaterial = false;
}