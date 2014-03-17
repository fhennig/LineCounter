package linecounter.logic.fileinfo;

public abstract class FileInfo
{
	protected String _fileName;
	protected String _fileExtension;
	protected String _amountChildren;

	public String getName()
	{
		return _fileName;
	}

	public String getExtension()
	{
		return _fileExtension;
	}

	public String getAmountChildren()
	{
		return _amountChildren;
	}
	public abstract int getStat(String statName);
}
