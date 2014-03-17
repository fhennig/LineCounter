package linecounter.logic.fileinfo;

public interface FileInfo
{
	public String getName();
	public String getExtension();
	public String getAmountChildren();
	public int getStat(String statName);
}
