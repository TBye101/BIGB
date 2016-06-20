package sneaky.bigb.entity.thief;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public class EntityThief extends EntityCreature
{
	public EntityThief(World world)
	{
		super(world);
		this.deathTime = 10000;
		this.experienceValue = 50;
	}
}