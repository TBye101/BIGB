package sneaky.bigb.lib.auto;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;
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
		
	}
	
	public static void DetectMissingStuff()
	{
		int b = 0;
		
		while (b != 9999999)
		{
			Item c = Item.getItemById(b);
			if (c != null)
			{
				if (c.getUnlocalizedName() != null)
				{
					//DoItemLogicHere
				}
			}
			b++;
		}
	}
	
	/**
	 * This searches for a solid block of the metal. This requires the ingot to be found or made first.
	 */
	public static OreStuff SearchForBlocksRelatedToThisOre(OreStuff current)
	{
		OreStuff curry;
		@SuppressWarnings("unchecked")
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		ItemStack[] Search;
		
		curry = current;
		Search = new ItemStack[]{new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot), new ItemStack(current.MetalIngot)};
				
		ShapedRecipes cur;
				
		for(int i = 0; i < recipes.size(); i++)
		{
			cur = (ShapedRecipes) recipes.get(i);
			    	
			if (cur.recipeItems == Search)
			   {
			    		
			    ItemStack out = cur.getRecipeOutput();
			    		
			    curry.MetalBlock = Block.getBlockFromItem(out.getItem());
			    return curry;
			   }
		}
			    
		return curry;
	}
	
	/**
	 * Returns a list of OreStuff, with just the ore part filled out.
	 */
	public static List<OreStuff> SearchForAnNewOre()
	{
		List<OreStuff> ret = null;
		
		int f = 0;
		int d = 0;
		
		while (f != 9999999)
		{
			Block e = Block.getBlockById(f);
			if (Block.getIdFromBlock(e) == 0)
			{
				d++;
				if (d == 100)
				{
					return ret;
				}
			}
			else
			{
				if (e.getLocalizedName().toLowerCase().contains("ore") || e.getUnlocalizedName().toLowerCase().contains("ore"))
				{
					OreStuff ne;
					ne = new OreStuff();
					ne.OreBlock = e;
				}
			}
			f++;
		}
		
		return ret;
	}
	
	
}
