package linecounter.logic.fileinfo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FolderFileInfo extends FileInfo
{
	private final Map<String, Integer> _stats = new HashMap<String, Integer>();
	
	
	
	public FolderFileInfo(File folder, Set<String> statsToUse, List<FileInfo> childInfo)
	{
		if (!folder.isDirectory())
			throw new IllegalArgumentException();
		
		_fileName = folder.getName();
		_fileExtension = "";
		_amountChildren = new Integer(childInfo.size()).toString();
		initStats(statsToUse, childInfo);
	}
	
	
	
	private void initStats(Set<String> statsToUse, List<FileInfo> childInfo)
	{
		for (String key : statsToUse)
		{
			int statsSum = 0;
			for (FileInfo child : childInfo)
			{
				statsSum += child.getStat(key);
			}
			_stats.put(key, statsSum);
		}
	}

	@Override
	public int getStat(String statName)
	{
		return _stats.get(statName);
	}
}
