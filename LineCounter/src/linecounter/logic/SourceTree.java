package linecounter.logic;

import java.io.File;

public class SourceTree
{
	private SourceInformation _root;
	private LineFilter _filter;
	private String _name = "Tree";
	
	public SourceTree(File file, LineFilter filter)
	{
		_filter = filter;
		
		if (file.isFile())
			_root = new DefaultSourceInformation(file, _filter);
//		else if (file.isDirectory())
//			_
		getTree(null); //TODO
	}
	
	private SourceInformation getTree(File file)
	{
		return null;
		//TODO rekursiv aufrufen ....
	}
	
	public SourceInformation getRoot()
	{
		return _root;
	}
	
//	private List<SourceInformation> getChildren(File directory)
//	{
//		List<SourceInformation> result = new ArrayList<>();
//		
//		for (File file : directory.listFiles())
//		{
//			result.add(new DefaultSourceInformation(file, _filter));
//		}
//	}
	
	@Override
	public String toString()
	{
		return _name;
	}
}
