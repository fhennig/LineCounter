package linecounter.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SourceDirectory extends SourceContainer
{
	private List<SourceContainer> _children = new ArrayList<>();
	
	
	
	public SourceDirectory(File directory)
	{
		super(directory);
		if (!directory.isDirectory())
			throw new IllegalArgumentException(directory + " is not a Directory!");
				
		for (File f : directory.listFiles())
		{
			if (f.isFile())
				_children.add(new SourceFile(f));
			else if (f.isDirectory())
				_children.add(new SourceDirectory(f));
		}
	}
	
	@Override
	public int getLineCount()
	{
		int lineCount = 0;
		for (SourceContainer sc : _children)
			lineCount += sc.getLineCount();
		return lineCount;
	}

	@Override
	public List<SourceContainer> getChildren()
	{
		return Collections.unmodifiableList(_children);
	}
}
