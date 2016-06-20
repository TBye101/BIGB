package sneaky.bigb.compat.extrautilities;

import com.rwtema.extrautils.block.BlockAngelBlock;
import com.rwtema.extrautils.item.ItemDivisionSigil;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ExtraUtilitiesCrafting
{
	public static void RegisterAll()
	{
		RegisterActivatedDivisionSigilRecipe();
	}
	
	public static void RegisterActivatedDivisionSigilRecipe()
	{
		//GameRegistry.addShapedRecipe(ItemDivisionSigil.newActiveSigil(), new Object[] {"AB ", "   ", "   ", 'A', Item.getItemFromBlock(new BlockAngelBlock()), 'B', new ItemDivisionSigil()});
	}
}