package sneaky.bigb.lib.auto;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import sneaky.bigb.lib.auto.create.AutoAxe;
import sneaky.bigb.lib.auto.create.AutoBlock;
import sneaky.bigb.lib.auto.create.AutoHoe;
import sneaky.bigb.lib.auto.create.AutoItem;
import sneaky.bigb.lib.auto.create.AutoPickaxe;
import sneaky.bigb.lib.auto.create.AutoSpade;
import sneaky.bigb.lib.auto.create.AutoSword;

/**
 * @author SneakyTactician
 * A class full of useful utilities that help simplify/speed up ore and tool creation.
 */
public class AutoItemAndBlock
{
	/**
	 * Creates a ore from the specs provided.
	 */
	public static Block CreateOre(Material material, boolean isOpaqueCube, float Hardness, float Resistence, int LightOpacity, String HarvestTool, int HarvestLevel, SoundType StepSound, String BlockName, CreativeTabs CreativeTab, int LightValue, boolean NeedsRandomTick, boolean UseNeighborBrightness, String TextureName)
	{
		Block ore;
		ore = new AutoBlock(material, UseNeighborBrightness, Resistence, Resistence, LightValue, TextureName, LightValue, StepSound, TextureName, CreativeTab, LightValue, UseNeighborBrightness, UseNeighborBrightness, TextureName);
		return ore;
	}
	
	/**
	 * Creates a pickaxe from the specs provided.
	 */
	public static ItemPickaxe CreatePickaxe(ToolMaterial material, float EfficiencyOnProperMaterial, int maxStackSize, CreativeTabs creativetab, int mininglevel, String texturename, String UnlocalizedName)
	{
		ItemPickaxe pick;
		pick = new AutoPickaxe(material, EfficiencyOnProperMaterial, maxStackSize, creativetab, mininglevel, texturename, UnlocalizedName);
		return pick;
	}
	
	/**
	 * Creates a sword from the specs provided.
	 */
	public static ItemSword CreateSword(ToolMaterial toolmaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		ItemSword sword;
		sword = new AutoSword(toolmaterial, creativetab, mininglevel, texture, unlocalizedname);
		return sword;
	}
	
	/**
	 * Creates a axe from the specs provided.
	 */
	public static ItemAxe CreateAxe(ToolMaterial toolmaterial, float EfficiencyOnProperMaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		ItemAxe axe;
		axe = new AutoAxe(toolmaterial, EfficiencyOnProperMaterial, creativetab, mininglevel, texture, unlocalizedname);
		return axe;
	}
	
	/**
	 * Creates a hoe from the specs provided.
	 */
	public static ItemHoe CreateHoe(ToolMaterial toolmaterial, CreativeTabs creativetab, int mininglevel, String texture, String unlocalizedname)
	{
		ItemHoe hoe;
		hoe = new AutoHoe(toolmaterial, creativetab, mininglevel, texture, unlocalizedname);
		return hoe;
	}
	
	/**
	 * Creates a shovel from the specs provided.
	 */
	public static ItemSpade CreateShovel(ToolMaterial toolmaterial, CreativeTabs creative, int mininglevel, String Texture, String UnlocalizedName)
	{
		ItemSpade shovel;
		shovel = new AutoSpade(toolmaterial, creative, mininglevel, Texture, UnlocalizedName);
		return shovel;
	}
	
	/**
	 * 	Creates a item from the specs provided.
	 */
	public static Item CreateItem(boolean Render3D, CreativeTabs creative, int MaxStackSize, String texture, String UnlocalizedName)
	{
		Item item;
		item = new AutoItem(Render3D, creative, MaxStackSize, texture, UnlocalizedName);
		return item;
	}
	
	/**
	 * Creates a ToolMaterial from the specs provided.
	 */
	public static ToolMaterial CreateToolMaterial(String MaterialName, int HarvestLevel, int MaxUses, float Efficiency, float Damage, int Enchantability)
	{
		Item.ToolMaterial material = EnumHelper.addToolMaterial(MaterialName, HarvestLevel, MaxUses, Efficiency, Damage, Enchantability);
		return material;
	}
}