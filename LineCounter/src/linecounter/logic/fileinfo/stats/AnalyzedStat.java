package linecounter.logic.fileinfo.stats;

public interface AnalyzedStat
{
	public void analyzeLine(String line);
	public int getValue();
	public AnalyzedStat cloneSetup();
}
