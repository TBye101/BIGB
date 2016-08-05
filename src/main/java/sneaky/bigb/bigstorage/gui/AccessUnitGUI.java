package sneaky.bigb.bigstorage.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import sneaky.bigb.bigstorage.accessunits.AccessUnitContainer;
import sneaky.bigb.main.Reference;

/**
 * @author SneakyTactician
 * This class draws the GUI for the access unit.
 */
@SideOnly(Side.CLIENT)
public class AccessUnitGUI extends GuiContainer
{
	
	public static final ResourceLocation BackgroundTexture = new ResourceLocation(Reference.MODID +":textures/gui/container/GenericInventoryBackground.png");
	public final InventoryPlayer PlayerInv;
	public final IInventory BIGInv;
	
	/**
	 * The constructor for the AccessUnitGUI class.
	 */
	public AccessUnitGUI(InventoryPlayer PlayerInventory, IInventory BIGInventory)
	{
		super(new AccessUnitContainer(PlayerInventory, BIGInventory));
		this.PlayerInv = PlayerInventory;
		this.BIGInv = BIGInventory;
	}
	
    @Override
    public void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = BIGInv.getInventoryName();
        fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2, 6, 4210752);
        fontRendererObj.drawString(PlayerInv.getInventoryName(), 8, ySize - 96 + 2, 4210752);
    }

	
    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(BackgroundTexture);
        int marginHorizontal = (width - xSize) / 2;
        int marginVertical = (height - ySize) / 2;
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);
    }
}