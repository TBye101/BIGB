package sneaky.bigb.compat.nei;

import java.util.List;

import codechicken.nei.VisiblityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import sneaky.bigb.bigstorage.gui.AccessUnitGUI;

/**
 * @author SneakyTactician
 * This is used to hide some NEI buttons
 */
public class ModNEIGUIHandler implements INEIGuiHandler
{
	@Override
	public VisiblityData modifyVisiblity(GuiContainer gui, VisiblityData currentVisibility)
	{
		if (gui instanceof AccessUnitGUI)
		{
			if (currentVisibility.showSearchSection)
			{
				currentVisibility.showSearchSection = false;
			}
		}
		
		return null;
	}

	@Override
	public Iterable<Integer> getItemSpawnSlots(GuiContainer gui, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaggedInventoryArea> getInventoryAreas(GuiContainer gui) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean handleDragNDrop(GuiContainer gui, int mousex, int mousey, ItemStack draggedStack, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hideItemPanelSlot(GuiContainer gui, int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		return false;
	}

}
