package sneaky.bigb.lib.auto;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.helpers.RegisterHelper;
import sneaky.bigb.main.Reference;
import sneaky.bigb.main.Util;
import sneaky.bigb.tabs.ModTabs;
import sneaky.bigb.type.*;

/**
 * @author SneakyTactician
 *  A class to auto create missing things for ores.
 */
public class AutoCreateForOres
{
	
	public static List<OreStuff> OreStuffStorage;
	
	/**
	 * This kicks off a process which scans all of the ores, and fills in missing items and blocks to go along with the ore.
	 */
	public static void Go()
	{
		//OreStuffStorage = SearchForAnNewOre();
		
		//AddSpecificOreStuffs();
		
		//if (OreStuffStorage.size() > 0)
		//{
		//	for(int i = 0; i < OreStuffStorage.size(); i++)
		//	{
		//		FillOutOre(OreStuffStorage.get(i));
		//	}
			
	//		RegisterAll();
	//	}
	//	else
	///	{
	//		LogHelper.info("There's nothing to auto create tools for here!??!");
	//	}
	//	
	}
	
	/**
	 * Enables you to manually find them, add them, and them have them auto processed.
	 */
	public static void AddSpecificOreStuffs()
	{
		
	}
	
	/**
	 * Registers all auto created tools, items, and blocks with Minecraft.
	 */
	public static void RegisterAll()
	{
		try
		{
			for(int i = 0; i < OreStuffStorage.size(); i++)
			{
				OreStuff current = OreStuffStorage.get(i);
				
				if (!current.HasMetalIngot)
				{
					RegisterHelper.registerItem(current.MetalIngot);
				}
				
				if (!current.HasMetalNugget)
				{
					RegisterHelper.registerItem(current.MetalNugget);
				}
				
				if (!current.HasAxe)
				{
					RegisterHelper.registerItem(current.Axe);
				}
				
				if (!current.HasHoe)
				{
					RegisterHelper.registerItem(current.Hoe);
				}
				
				if (!current.HasPickaxe)
				{
					RegisterHelper.registerItem(current.Pickaxe);
				}
				
				if (!current.HasShovel)
				{
					RegisterHelper.registerItem(current.Shovel);
				}
				
				if (!current.HasSword)
				{
					RegisterHelper.registerItem(current.Sword);
				}
				
				LogHelper.info("Finished registering 1 ore");
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	/**
	 * Finds or generates everything for an ore.
	 */
	public static void FillOutOre(OreStuff stuff)
	{
			PopulateMaterial(stuff);
			PopulateMetalIngot(stuff);
			PopulateMetalBlock(stuff);
			PopulateNugget(stuff);
			PopulateSword(stuff);
			PopulatePickaxe(stuff);
			PopulateAxe(stuff);
			PopulateHoe(stuff);
			PopulateShovel(stuff);
	}
	
	/**
	 * Creates a tool material.
	 */
	public static void PopulateMaterial(OreStuff stuff)
	{
			int harvest = stuff.OreBlock.getLightOpacity() / 3;
			harvest++;
			int durability = stuff.OreBlock.getBlockColor() * stuff.OreBlock.getLightOpacity();
			int efficiency = stuff.OreBlock.getBlockColor() / 3 + 10;
			int damage = stuff.OreBlock.getLightValue() - 2;
			
			ToolMaterial material = AutoItemAndBlock.CreateToolMaterial(stuff.BaseName, harvest, durability, efficiency, damage, 1);
			stuff.MetalMaterial = material;
			stuff.HasMetalMaterial = true;
	}
	
	/**
	 * Finds or creates a ingot for an ore.
	 */
	public static void PopulateMetalIngot(OreStuff stuff)
	{
		if (!stuff.HasMetalIngot)
		{
			ItemStack MetalIngot = Util.FindItemStackFromObjectInputed(new ItemStack(stuff.OreBlock));
			if (MetalIngot != null)
			{
				stuff.HasMetalIngot = true;
				stuff.MetalIngot = MetalIngot.getItem();
			}
			else
			{
			 stuff.MetalIngot = AutoItemAndBlock.CreateItem(true, ModTabs.maintab, 64, Reference.MODID + ":MissingIngotTexture", stuff.BaseName + "Ingot");
			}
		}
	}
	
	/**
	 * Finds or creates a block for an ore.
	 */
	public static void PopulateMetalBlock(OreStuff stuff)
	{
		if (!stuff.HasMetalBlock)
		{
			Block MetalBlock = Util.FindBlockFromString(stuff.BaseName + "block");
			
			if (MetalBlock != null)
			{
				stuff.HasMetalBlock = true;
				stuff.MetalBlock = MetalBlock;
			}
			else
			{
			Material mat;
			mat = Material.ground;
			stuff.MetalBlock = AutoItemAndBlock.CreateOre(mat, true, 30F, 30F, 0, "pickaxe", Util.rand.nextInt(3), Block.soundTypeMetal, stuff.BaseName + "Block", ModTabs.maintab, 0, false, false, /*Reference.MODID + */"MissingMetalBlockTexture");
			}
		}
	}
	
	/**
	 * Finds or creates a nugget for an ore.
	 */
	public static void PopulateNugget(OreStuff stuff)
	{
		if (!stuff.HasMetalNugget)
		{
			Item MetalNugget = Util.FindItemFromString(stuff.BaseName + "nugget");
			
			if (MetalNugget != null)
			{
				stuff.HasMetalNugget = true;
				stuff.MetalNugget = MetalNugget;
			}
			else
			{
				Item nug;
				nug = AutoItemAndBlock.CreateItem(false, ModTabs.maintab, 64, Reference.MODID + ":MissingNuggetTexture", stuff.BaseName + "Nugget");
				stuff.MetalNugget = nug;
			}
		}
	}
	
	/**
	 * Finds or creates a sword for an ore.
	 */
	public static void PopulateSword(OreStuff stuff)
	{
		if (!stuff.HasSword)
		{
			Item Sword = Util.FindItemFromString(stuff.BaseName + "sword");
			
			if (Sword != null)
			{
				stuff.HasSword = true;
			}
			else
			{
				ItemSword sword = AutoItemAndBlock.CreateSword(stuff.MetalMaterial, ModTabs.maintab, 0, Reference.MODID + ":MissingSwordTexture", stuff.BaseName + "Sword");
				stuff.Sword = sword;
			}
		}
	}
	
	/**
	 * Finds or creates a pickaxe for an ore.
	 */
	public static void PopulatePickaxe(OreStuff stuff)
	{
		if (!stuff.HasPickaxe)
		{
			Item Pickaxe = Util.FindItemFromString(stuff.BaseName + "pick");
			
			if (Pickaxe != null)
			{
				stuff.HasPickaxe = true;
			}
			else
			{
				ItemPickaxe pick;
				pick = AutoItemAndBlock.CreatePickaxe(stuff.MetalMaterial, Util.rand.nextInt(10), 1, ModTabs.maintab, stuff.MetalMaterial.getHarvestLevel(), Reference.MODID + ":MissingPickaxeTexture", stuff.BaseName + "Pickaxe");
				stuff.Pickaxe = pick;
			}
		}
	}
	
	/**
	 * Finds or creates a axe for an ore.
	 */
	public static void PopulateAxe(OreStuff stuff)
	{
		if (!stuff.HasAxe)
		{
			Item Axe = Util.FindItemFromString(stuff.BaseName + "axe");
			
			if (Axe != null)
			{
				stuff.HasAxe = true;
			}
			else
			{
				ItemAxe axe;
				axe = AutoItemAndBlock.CreateAxe(stuff.MetalMaterial, Util.rand.nextInt(10), ModTabs.maintab, stuff.MetalMaterial.getHarvestLevel(), Reference.MODID + ":MissingAxeTexture", stuff.BaseName + "Axe");
				stuff.Axe = axe;
			}
		}
	}
	
	/**
	 * Finds or creates a hoe for an ore.
	 */
	public static void PopulateHoe(OreStuff stuff)
	{
		if (!stuff.HasHoe)
		{
			Item Hoe = Util.FindItemFromString(stuff.BaseName + "hoe");
			
			if (Hoe != null)
			{
				stuff.HasHoe = true;
			}
			else
			{
				ItemHoe hoe;
				hoe = AutoItemAndBlock.CreateHoe(stuff.MetalMaterial, ModTabs.maintab, stuff.MetalMaterial.getHarvestLevel(), Reference.MODID + ":MissingHoeTexture", stuff.BaseName + "Hoe");
				stuff.Hoe = hoe;
			}
		}
	}
	
	/**
	 * Finds or creates a shovel for an ore.
	 */
	public static void PopulateShovel(OreStuff stuff)
	{
		if (!stuff.HasShovel)
		{
			Item Shovel = Util.FindItemFromString(stuff.BaseName + "shovel");
			
			if (Shovel != null)
			{
				stuff.HasShovel = true;
			}
			else
			{
				ItemSpade shovel;
				shovel = AutoItemAndBlock.CreateShovel(stuff.MetalMaterial, ModTabs.maintab, stuff.MetalMaterial.getHarvestLevel(), Reference.MODID + ":MissingShovelTexture", stuff.BaseName + "Shovel");
				stuff.Shovel = shovel;
			}
		}
	}
	
	/**
	 * Returns a list of OreStuff, with just the ore part filled out.
	 */
	public static List<OreStuff> SearchForAnNewOre()
	{
		List<OreStuff> ret = new ArrayList<OreStuff>();
		
		//int i = 0;
		//int size = ModConfig.LoadAllOresToAutoGenFor().length;
		
	//	size++;
	//	String[] ores = new String[size];
		
	//	ores = ModConfig.LoadAllOresToAutoGenFor();
		
		//while (i != ores.length)
		{
		//	OreStuff next;
		//	next = new OreStuff();
		//	next.HasOreBlock = true;
		//	next.OreBlock = Block.getBlockFromName(ores[i]);
			
		//	if (next.OreBlock == null)
			{
		//		LogHelper.ErrorAlways("Could not find block: " + ores[i] + " for autogeneration of tools");
			}
		//	else
			{
				//ret.add(next);
			}
		//	i++;
		}
		
		return ret;
	}
	
	public static String GetBaseName(String UnlocalizedName)
	{
		String a;
		a = UnlocalizedName;
		a.substring(5);
		a.substring(a.length() - 3, a.length());
		return a;
	}
}