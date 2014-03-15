package linecounter.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummarizedSourceInformation extends SourceInformation
{
	private final List<SourceInformation> _children = new ArrayList<>();
	
	
	
	public SummarizedSourceInformation(List<SourceInformation> children)
	{
		_children.addAll(children);
		
		init();
	}
		
	private void init()
	{
		for (SourceInformation c : _children)
		{
			_allLines += c.getLines();
			_sourceLines += c.getSourceLines();
			_docLines += c.getDocLines();
			_emptyLines += c.getEmptyLines();
		}
	}
	
	@Override
	public List<SourceInformation> getChildren()
	{
		return Collections.unmodifiableList(_children);
	}
}
