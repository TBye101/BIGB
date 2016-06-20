package sneaky.bigb.lib.auto;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import sneaky.bigb.config.ModConfig;
import sneaky.bigb.helpers.LogHelper;

public class AutoRotate
{
	public static void RotateBlocks()
	{
		int d = 0;
		int f = 0;
		while (f != 9999999)
		{
			Block e = Block.getBlockById(f);
			if (Block.getIdFromBlock(e) == 0)
			{
				d++;
				if (d == 100)
				{
					return;
				}
			}
			else
			{
				//Rotate here
			}
			f++;
		}
	}
}
