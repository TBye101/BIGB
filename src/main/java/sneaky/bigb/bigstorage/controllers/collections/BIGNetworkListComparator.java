package sneaky.bigb.bigstorage.controllers.collections;

import java.util.Comparator;

import sneaky.bigb.bigstorage.IBIGStorage;

public class BIGNetworkListComparator implements Comparator<IBIGStorage>
{

	@Override
	public int compare(IBIGStorage arg0, IBIGStorage arg1)
	{
		return arg0.ID.hashCode() - arg1.ID.hashCode();
	}
}