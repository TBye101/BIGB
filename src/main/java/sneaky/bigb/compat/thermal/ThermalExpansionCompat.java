package sneaky.bigb.compat.thermal;

import cofh.thermalexpansion.api.crafting.CraftingHandlers;
import cofh.thermalexpansion.util.crafting.PulverizerManager;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.compat.extrautilities.ExtraUtilitiesCrafting;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.item.ModItems;

/**
 * @author SneakyTactician
 * The class that handles all Thermal Expansion compatibility stuff.
 */
public class ThermalExpansionCompat
{
	
	
	/**
	 * The first main sweep of logic for Extra Utilities compatibility
	 */
	public static void preInit(FMLPreInitializationEvent event)
	{
		LogHelper.info("Thermal Expansion compat preInit started");
		LogHelper.info("Thermal Expansion compat preInit finished");
	}
	
	/**
	 * The second main sweep of logic for Extra Utilities compatibility
	 */
	public static void Init()
	{
		LogHelper.info("Thermal Expansion compat Init started");
		
		LogHelper.info("Thermal Expansion compat Init finished");
	}
	
	/**
	 * The third main sweep of logic for Extra Utilities compatibility
	 */
	public static void postInit()
	{
		LogHelper.info("Thermal Expansion compat postInit started");
		//CraftingHandlers.pulverizer.addRecipe(1000, new ItemStack(Item.getItemFromBlock(ModBlocks.TribaniumOre)), new ItemStack(ModItems.TribaniumDust, 2), new ItemStack(Blocks.gold_ore), 10, true);
		PulverizerManager.addRecipe(200, new ItemStack(Item.getItemFromBlock(ModBlocks.TribaniumOre)), new ItemStack(ModItems.TribaniumDust, 2), new ItemStack(Items.diamond), 2);
		
		GameRegistry.addSmelting(ModItems.TribaniumDust, new ItemStack(ModItems.TribaniumIngot), 10);
		GameRegistry.addSmelting(Items.diamond, new ItemStack(Items.diamond), 0);
		LogHelper.info("Thermal Expansion compat postInit finished");
	}
}
