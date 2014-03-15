package linecounter.logic;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import linecounter.logic.linefilter.FileAnalyzer;

public class SourceTree
{
	private SourceInformation _root;
	private FileAnalyzer _fileAnalyzer;
	
	public SourceTree(File file, FilenameFilter fileFilter, FileAnalyzer fileAnalyzer)
	{
		_fileAnalyzer = fileAnalyzer;
		
		_root = getTree(file);
	}
	
//	private SourceInformation initRoot(File file)
//	{
//		SourceInformation root = getTree(file);
//		return root; //TODO
//			
//	}
	
	private SourceInformation getTree(File file)
	{
		if (file.isFile())
		{
			return _fileAnalyzer.analyze(file);
		}
		else if (file.isDirectory())
		{
			List<SourceInformation> children = new ArrayList<>();
			for (File subFile : file.listFiles())
			{
				SourceInformation subInfo = getTree(subFile);
				if (subInfo != null)
					children.add(subInfo);
			}
			return new SummarizedSourceInformation(children);
		}
		
		return null;
	}
	
	/** Can be null */
	public SourceInformation getRoot()
	{
		return _root;
	}
}
