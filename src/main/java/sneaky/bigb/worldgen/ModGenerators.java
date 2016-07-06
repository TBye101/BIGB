package sneaky.bigb.worldgen;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModGenerators
{
	public void RegisterAll()
	{
		GenerateWorld OreGen;
		GenTree XLOakTreeGen;
		
		OreGen = new GenerateWorld();
		XLOakTreeGen = new GenTree();
		
		GameRegistry.registerWorldGenerator(OreGen, 100);
		GameRegistry.registerWorldGenerator(XLOakTreeGen, 20);
	}
}