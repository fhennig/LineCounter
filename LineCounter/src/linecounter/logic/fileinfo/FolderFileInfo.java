package linecounter.logic.fileinfo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolderFileInfo implements FileInfo
{
	private final String _fileName;
	private final String _fileExtension;
	private final String _amountChildren;
	private final Map<String, Integer> _stats = new HashMap<String, Integer>();
	
	
	
	public FolderFileInfo(File folder, FileInfoPrototype prototype, List<FileInfo> childInfo)
	{
		if (!folder.isDirectory())
			throw new IllegalArgumentException();
		
		_fileName = folder.getName();
		_fileExtension = "";
		_amountChildren = new Integer(childInfo.size()).toString();
		initStats(prototype, childInfo);
	}
	
	
	
	private void initStats(FileInfoPrototype prototype, List<FileInfo> childInfo)
	{
		for (String key : prototype.cloneStatsKeys())
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
	public String getName()
	{
		return _fileName;
	}

	@Override
	public String getExtension()
	{
		return _fileExtension;
	}

	@Override
	public String getAmountChildren()
	{
		return _amountChildren;
	}

	@Override
	public int getStat(String statName)
	{
		return _stats.get(statName);
	}
}
