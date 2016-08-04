package sneaky.bigb.bigstorage.controllers.collections;

import java.util.Comparator;

import net.minecraft.item.ItemStack;

public class StorageStackComparator implements Comparator<StorageStack>
{
	
		@Override
		public int compare(StorageStack arg0, StorageStack arg1)
		{
			return arg0.TheItem.getUnlocalizedName().hashCode() - arg1.TheItem.getUnlocalizedName().hashCode();
		}
		public int compate(ItemStack arg0, StorageStack arg1)
		{
			return arg0.getItem().getUnlocalizedName().hashCode() - arg1.TheItem.getUnlocalizedName().hashCode();
		}
}