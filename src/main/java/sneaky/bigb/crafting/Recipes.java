package sneaky.bigb.crafting;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import sneaky.bigb.block.ModBlocks;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
import sneaky.bigb.item.ModItems;
import sneaky.bigb.main.Util;

/**
 * @author SneakyTactician
 * This class contains all sorts of logic that can influence and change Minecraft recipes.
 */
public class Recipes
{
	
	/**
	 * This method kicks off all sorts of different processes that change various things about Minecraft recipes.
	 */
	public static void RegisterAll()
	{
		MassRecipes();
		Smelting();
		Shaped();
		Shapeless();
		RemoveAllRecipes();
	}
	
	/**
	 * This method makes a call to Util.RemoveAllRecipes(), and logs right before the call and afterwards.
	 */
	public static void RemoveAllRecipes()
	{
		if (ModConfig.DisableAllRecipes())
		{
			LogHelper.info("Starting to remove all recipes");
			Util.RemoveAllRecipes();
			LogHelper.info("All done");
		}
	}
	
	/**
	 * This method kicks off and makes all sorts of massive changes to all recipes, such as swapping out all iron ingots for iron blocks.
	 * WIP
	 */
	public static void MassRecipes()
	{
		LogHelper.info("Starting mass recipe changes");
		
		MassSwapItemsInRecipes(null, null);
		
		LogHelper.info("Finished with mass recipe changes");
	}
	
	/**
	 * This method will change all instances of item a, for item b in all recipes registered with Minecraft at the time called.
	 * WIP
	 * @param a is an Item
	 * @param b is an Item
	 */
	public static void MassSwapItemsInRecipes(Item a, Item b)
	{
	    //ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    //for (int scan = 0; scan < recipes.size(); scan++)
	    //{
	    //    IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	    //    LogHelper.info("Recipe: " + tmpRecipe.toString());
	    //}
	}
	
	/**
	 * This method lists the names of all the recipes that are registered with Minecraft at the time called.
	 */
	public static void ListAllRecipes()
	{
	    @SuppressWarnings("rawtypes")
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++)
	    {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	        LogHelper.info("Recipe: " + tmpRecipe.toString());
	    }
	}
	
	/**
	 * This method starts all sorts of different changes to various smelting recipes in Minecraft.
	 */
	public static void Smelting()
	{
		LogHelper.info("Starting smelting changes");
		SmeltingRottenFleshToLeather();
		SmeltingTribaniumOre();
		LogHelper.info("Finished with smelting changes");
	}
	
	public static void Shaped()
	{
		LogHelper.info("Starting shaped recipe changes");
		ShapedAnvil();
		ShapedSandStone();
		ShapedNoteBlock();
		ShapedPoweredRail();
		ShapedChest();
		ShapedInvisibleBlock();
		ShapedShockProofClearGlass();
		LogHelper.info("Finished with shaped recipe changes");
	}
	
	/**
	 * This method kicks off all sorts of different shapeless recipe changes to Minecraft
	 */
	public static void Shapeless()
	{
		LogHelper.info("Starting shapeless recipe changes");
		ShapelessReinforcedLimeGreenWall();
		ShapelessReinforcedBlueWall();
		ShapelessReinforcedDarkBlueWall();
		ShapelessReinforcedLightBlueWall();
		ShapelessReinforcedOrangeWall();
		ShapelessReinforcedPinkWall();
		ShapelessReinforcedPurpleWall();
		ShapelessReinforcedRedWall();
		ShapelessReinforcedYellowWall();
		LogHelper.info("Finished with shapeless recipe changes");
	}
	
	public static void SmeltingTribaniumOre()
	{
		if (ModConfig.EnableTribaniumOre() && ModConfig.EnableTribaniumIngot())
		{
			GameRegistry.addSmelting(ModBlocks.TribaniumOre, new ItemStack(ModItems.TribaniumIngot), 4F);
		}
		else
		{
			LogHelper.info("Not adding a smelting recipe for Tribanium Ingots due to config settings");
		}
	}
	
	public static void ShapelessReinforcedYellowWall()
	{
		if (!ModConfig.DisableReinforcedYellowWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedyellowwall), 2), new Object[] {MetaRecipes.CreateDandelionYellow(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced yellow wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedRedWall()
	{
		if (!ModConfig.DisableReinforcedRedWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedredwall), 2), new Object[] {MetaRecipes.CreateRoseRed(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced red wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedPurpleWall()
	{
		if (!ModConfig.DisableReinforcedPurpleWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedpurplewall), 2), new Object[] {MetaRecipes.CreatePurpleDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced purple wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedPinkWall()
	{
		if (!ModConfig.DisableReinforcedPinkWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedpinkwall), 2), new Object[] {MetaRecipes.CreatePinkDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced pink wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedOrangeWall()
	{
		if (!ModConfig.DisableReinforcedOrangeWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedorangewall), 2), new Object[] {MetaRecipes.CreateOrangeDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced orange wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedLightBlueWall()
	{
		if (!ModConfig.DisableReinforcedLightBlueWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedlightbluewall), 2), new Object[] {MetaRecipes.CreateLightBlueDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced light blue wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedDarkBlueWall()
	{
		if (!ModConfig.DisableReinforcedDarkBlueWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforceddarkbluewall), 2), new Object[] {MetaRecipes.CreateLapisLazuli(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced dark blue wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedBlueWall()
	{
		if (!ModConfig.DisableReinforcedBlueWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedbluewall), 2), new Object[] {MetaRecipes.CreateCyanDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced blue wall due to it's config settings");
		}
	}
	
	public static void ShapelessReinforcedLimeGreenWall()
	{
		if (!ModConfig.DisableReinforcedLimeGreenWall())
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.reinforcedlimegreenwall), 2), new Object[] {MetaRecipes.CreateLimeDye(), new ItemStack(Blocks.obsidian, 4)});
		}
		else
		{
			LogHelper.info("Not adding a recipe for reinforced lime green wall due to it's config settings");
		}
	}
	
	public static void ShapedShockProofClearGlass()
	{
		if (!ModConfig.DisableShockProofClearGlass())
		{
			GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.shockproofclearglass), 4), new Object[] {"ABA", "BBB", "ABA", 'A', Blocks.obsidian, 'B', Blocks.glass});
		}
		else
		{
			LogHelper.info("Not adding a recipe for shock proof clear glass due to it's config settings");
		}
	}
	
	/**
	 * This method adds a recipe for the invisible block.
	 */
	public static void ShapedInvisibleBlock()
	{
		if (!ModConfig.DisableInvisibleBlock())
		{
			GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.invisibleblock), 8), new Object[] {"AAA", "ABA", "AAA", 'A', Blocks.glass, 'B', Items.diamond});
		}
		else
		{
			LogHelper.info("Not adding a recipe for invisible block, because invisible block has been disabled");
		}
	}
	
	/**
	 * This method changes the chest recipe in Minecraft if the config setting "DisableChestRecipe" does not equal true.
	 */
	public static void ShapedChest()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisableChestRecipe())
			{
				RemoveRecipe(new ItemStack(Item.getItemFromBlock(Blocks.chest)));
				GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.chest), 2), new Object[] {"ABA", "A A", "AAA", 'A', Blocks.planks, 'B', Items.iron_ingot});
			}
		}
	}
	
	/**
	 * This method changes the powered rail recipe in Minecraft if the config setting "DisablePoweredRailRecipe" does not equal true.
	 * WIP
	 */
	public static void ShapedPoweredRail()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisablePoweredRailRecipe())
			{
				RemoveRecipe(new ItemStack(Item.getItemFromBlock(Blocks.golden_rail)));
				GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(Blocks.golden_rail), 24), new Object[] {"A A", "ABA", "ACA", 'A', Item.getItemFromBlock(Blocks.gold_block), 'B', Items.stick, 'C', Item.getItemFromBlock(Blocks.redstone_block)});
				return;
			}
		}
		LogHelper.info("Not changing powered rail recipe (Minecraft) due to config settings");
	}
	
	/**
	 * This method changes the noteblock recipe in Minecraft if the config setting "DisableNoteBlockRecipe" does not equal true.
	 */
	public static void ShapedNoteBlock()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisableNoteBlockRecipe())
			{
				RemoveRecipe(new ItemStack(Item.getItemFromBlock(Blocks.noteblock)));
				GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(Blocks.noteblock)), new Object[] {"ABA", "BCB", "ABA", 'A', Item.getItemFromBlock(Blocks.log), 'B', Item.getItemFromBlock(Blocks.planks), 'C', Item.getItemFromBlock(Blocks.redstone_block)});
				return;
			}
		}
		LogHelper.info("Not changing sandstone recipe (Minecraft) due to config settings");
	}
	
	/**
	 * This method changes the sandstone recipe in Minecraft if the config setting "DisableSandStoneRecipe" does not equal true.
	 */
	public static void ShapedSandStone()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisableSandStoneRecipe())
			{
				RemoveRecipe(new ItemStack(Item.getItemFromBlock(Blocks.sandstone)));
				GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(Blocks.sandstone)), new Object[] {"AAA", "AAA", "AAA", 'A', Item.getItemFromBlock(Blocks.sand)});
				return;
			}
		}
		LogHelper.info("Not changing sandstone recipe (Minecraft) due to config settings");
	}
	
	/**
	 * This method changes the anvil recipe in Minecraft if the config setting "DisableAnvilRecipe" does not equal true.
	 */
	public static void ShapedAnvil()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisableAnvilRecipe())
			{
				RemoveRecipe(new ItemStack(Item.getItemFromBlock(Blocks.anvil)));
				GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(Blocks.anvil)), new Object[] {"AAA", " A ", "AAA", 'A', Item.getItemFromBlock(Blocks.iron_block)});
				return;
			}
		}
		LogHelper.info("Not changing anvil recipe (Minecraft) due to config settings");
	}
	
	/**
	 * This method adds a smelting recipe to Minecraft. Rotten flesh -> leather.
	 */
	public static void SmeltingRottenFleshToLeather()
	{
		if (ModConfig.DoModIntegrationsIfPossible())
		{
			if (!ModConfig.DisableLeatherRecipe())
			{
				RemoveRecipe(new ItemStack(Items.leather));
				GameRegistry.addSmelting(new ItemStack(Items.rotten_flesh, 3), new ItemStack(Items.leather), 1.5F);
				return;
			}
		}
		LogHelper.info("Not changing leather recipe (Minecraft) due to config settings");
	}
	
	//Removes all recipes that output the item that is passed in as a parameter
	/**
	 * This method removes all recipes registered with minecraft that produce the passed in item.
	 * @param resultItem
	 */
	@SuppressWarnings("rawtypes")
	public static void RemoveRecipe(ItemStack resultItem) //Code by yope_fried inspired by pigalot
	{
	    ItemStack recipeResult = null;
	    ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++)
	    {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	        if (tmpRecipe instanceof ShapedRecipes)
	        {
	            ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        }

	        if (tmpRecipe instanceof ShapelessRecipes)
	        {
	            ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        }
	        
	        if (tmpRecipe instanceof ShapedOreRecipe)
	        {
	                          ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
	          recipeResult = recipe.getRecipeOutput();
	        }

	        if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
	        {
	            System.out.println("[BIGB] Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
	            recipes.remove(scan);
	        }
	    }
	}
}