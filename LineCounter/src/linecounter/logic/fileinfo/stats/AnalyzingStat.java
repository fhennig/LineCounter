package linecounter.logic.fileinfo.stats;

public interface AnalyzingStat
{
	public void analyzeLine(String line);
	public int getValue();
	public AnalyzingStat cloneSetup();
}
