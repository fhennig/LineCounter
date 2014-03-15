package linecounter.logic;

import java.io.File;

public class SourceTree<S extends FileStats>
{
	private final SourceNode<S> _root;
	
	
	
	public SourceTree(File file, TreeConfig<S> analyzer)
	{
		if ((file.isFile() && !analyzer.getFileFilter().accept(file)) || 
				!(file.isDirectory() || file.isFile()))
			file = new File("null");
		
		_root = new SourceNode<>(file, analyzer);
	}
	
	
	
	public SourceNode<S> getRoot()
	{
		return _root;
	}
}
