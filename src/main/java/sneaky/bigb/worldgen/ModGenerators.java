package sneaky.bigb.worldgen;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModGenerators
{
	public void RegisterAll()
	{
		GenerateWorld OreGen;
		GenTree TreeGen;
		
		OreGen = new GenerateWorld();
		TreeGen = new GenTree();
		
		GameRegistry.registerWorldGenerator(OreGen, 100);
		GameRegistry.registerWorldGenerator(TreeGen, 20);
	}
}