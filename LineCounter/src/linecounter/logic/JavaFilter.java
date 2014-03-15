package linecounter.logic;

public class JavaFilter implements LineFilter
{
	@Override
	public boolean isEmpty(String line)
	{
		return line.isEmpty();
	}

	@Override
	public boolean isDoc(String line)
	{
		line = line.trim();
		boolean result = (line.startsWith("//") ||
						  line.startsWith("/*") ||
						  line.startsWith("*") ||
						  line.startsWith("*/"));
		return result;
	}

	@Override
	public boolean isSource(String line)
	{
		if (!isEmpty(line) && !isDoc(line))
			return true;
		return false;
	}
}
