package sneaky.bigb.bigstorage.controllers.collections;

import java.util.Comparator;

import net.minecraft.item.ItemStack;

public class StorageStackComparator implements Comparator<StorageStack>
{
	
		@Override
		public int compare(StorageStack arg0, StorageStack arg1)
		{
			if (arg0.TheItem == null && arg1.TheItem == null)
			{
				return 0;
			}
			
			if (arg0.TheItem == null)
			{
				return arg1.TheItem.getUnlocalizedName().hashCode();
			}
			
			if (arg1.TheItem == null)
			{
				return arg0.TheItem.getUnlocalizedName().hashCode();
			}
			
			return arg0.TheItem.getUnlocalizedName().hashCode() - arg1.TheItem.getUnlocalizedName().hashCode();
		}
		public int compare(ItemStack arg0, StorageStack arg1)
		{
			if (arg0 == null && arg1 == null)
			{
				return 0;
			}
			
			if (arg0 == null)
			{
				return arg1.TheItem.getUnlocalizedName().hashCode();
			}
			
			if (arg1 == null)
			{
				return arg0.getUnlocalizedName().hashCode();
			}
			
			return arg0.getItem().getUnlocalizedName().hashCode() - arg1.TheItem.getUnlocalizedName().hashCode();
		}
}