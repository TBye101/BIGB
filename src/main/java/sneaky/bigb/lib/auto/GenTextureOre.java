package sneaky.bigb.lib.auto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import sneaky.bigb.main.Util;

/**
 * @author SneakyTactician
 *	Generates a random texture for an ore.
 */
public class GenTextureOre
{
	/**
	 * Returns a randomly generated texture for an ore.
	 */
	//public BufferedImage GenerateRandomOreTexture()
	//{
		/*TextureAtlasSprite a;
		TextureUtil b;
		BufferedImage OreTexture;
		
		int R;
		int G;
		int B;
		int color1;
		int color2;
		
		OreTexture = this.GetOreBase();
		
		if (OreTexture != null)
		{
			System.out.print("We made it!");
		}
		
		R = Util.rand.nextInt(255);
		G = Util.rand.nextInt(255);
		B = Util.rand.nextInt(255);
		color1 = this.CreateRGB(R, G, B);
		color2 = this.CreateRGB(R - 10, G - 10, B - 10);
		
		OreTexture = this.FillInOre(OreTexture, color1, color2);
		
		return OreTexture;
		*/
	//}
	
	/**
	 * 
	 * 
	 * Magically creates an RGB value.
	 *
	 */
	public int CreateRGB(int R, int G, int B)
	{
		Color color = new Color(R, G, B); // Color white
		int rgb = color.getRGB();
		return rgb;
	}
	
	/**
	 * Loads the OreBase .png from the jar.
	 */
	public BufferedImage GetOreBase()
	{
		BufferedImage img;
		
	//	try 
	//	{
			img = this.loadImage("/assets/bigb/textures/blocks/OreBase.png");
			
			//if (in == null)
			//{
			//	System.out.println("Cannot read OreBase.png");
		//	}
			
			//img = ImageIO.read(in);
		//} 
		//catch (IOException e)
		//{
		//	e.printStackTrace();
		//	System.out.print(e.getMessage());
		//	
		//	img = null;
		//}
		
		return img;
	}
	
	/**
	 * Fills in some details on the new ore texture.
	 * Returns a bufferedimage.
	 */
	public BufferedImage FillInOre(BufferedImage base, int color1, int color2)
	{
		BufferedImage re = base;
		
		re = this.SetPixelRandomColor(color1, color2, 4, 2, re);
		re = this.SetPixelRandomColor(color1, color2, 12, 2, re);
		re = this.SetPixelRandomColor(color1, color2, 13, 2, re);
		re = this.SetPixelRandomColor(color1, color2, 7, 3, re);
		re = this.SetPixelRandomColor(color1, color2, 8, 3, re);
		re = this.SetPixelRandomColor(color1, color2, 5, 5, re);
		re = this.SetPixelRandomColor(color1, color2, 6, 5, re);
		re = this.SetPixelRandomColor(color1, color2, 10, 5, re);
		re = this.SetPixelRandomColor(color1, color2, 11, 5, re);
		re = this.SetPixelRandomColor(color1, color2, 3, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 4, 2, re);
		re = this.SetPixelRandomColor(color1, color2, 4, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 5, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 6, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 10, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 11, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 1, 8, re);
		re = this.SetPixelRandomColor(color1, color2, 2, 8, re);
		re = this.SetPixelRandomColor(color1, color2, 8, 8, re);
		re = this.SetPixelRandomColor(color1, color2, 9, 8, re);
		re = this.SetPixelRandomColor(color1, color2, 7, 9, re);
		re = this.SetPixelRandomColor(color1, color2, 8, 9, re);
		re = this.SetPixelRandomColor(color1, color2, 9, 9, re);
		re = this.SetPixelRandomColor(color1, color2, 10, 9, re);
		re = this.SetPixelRandomColor(color1, color2, 4, 10, re);
		re = this.SetPixelRandomColor(color1, color2, 11, 11, re);
		re = this.SetPixelRandomColor(color1, color2, 12, 11, re);
		re = this.SetPixelRandomColor(color1, color2, 8, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 5, 6, re);
		re = this.SetPixelRandomColor(color1, color2, 9, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 10, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 11, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 12, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 13, 12, re);
		re = this.SetPixelRandomColor(color1, color2, 3, 13, re);
		re = this.SetPixelRandomColor(color1, color2, 4, 13, re);
		re = this.SetPixelRandomColor(color1, color2, 9, 13, re);
		re = this.SetPixelRandomColor(color1, color2, 10, 13, re);
		
		return re;
	}
	
	/**
	 * Sets the specified pixel in the BufferedImage to one of the 2 colors specified.
	 */
	public BufferedImage SetPixelRandomColor(int color1, int color2, int x, int y, BufferedImage re)
	{
		BufferedImage ret = re;
		
		if (Util.rand.nextInt(1) == 0)
		{
			ret.setRGB(x, y, color1);
		}
		else
		{
			ret.setRGB(x, y, color2);
		}
		
		return ret;
	}
	
	 public BufferedImage loadImage(String fileName)
	 {
		    BufferedImage buff;
		    
		    try
		    {
		        buff = ImageIO.read(getClass().getResourceAsStream(fileName));
		    } 
		    catch (IOException e)
		    {
		        e.printStackTrace();
		        return null;
		    }
		    return buff;
		}
}