package sneaky.bigb.bigstorage.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import sneaky.bigb.bigstorage.accessunits.AccessUnitContainer;
import sneaky.bigb.gui.GUIUtils;
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
	 * The Minecraft instance.
	 */
	Minecraft mc = Minecraft.getMinecraft();
	
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
        fontRendererObj.drawString(PlayerInv.player.getDisplayName() + "'s Inventory", 8, ySize - 96 + 2, 4210752);
    }

	
    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(BackgroundTexture);
        int marginHorizontal = (width - xSize) / 2;
        
        
        int marginVertical = GUIUtils.GetSHeight() / 80;
        
        //X draw point, Y draw point, Scale X, Scale y, Show N of X texture, Show N of Y Texture
        drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, 256, 256);
    }
}