package linecounter.logic;

public interface LineFilter
{
	public boolean isEmpty(String line);
	public boolean isDoc(String line);
	public boolean isSource(String line);
}
