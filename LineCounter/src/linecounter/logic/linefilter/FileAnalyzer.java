package linecounter.logic.linefilter;

import java.io.File;

import linecounter.logic.SourceInformation;

public interface FileAnalyzer
{
	public SourceInformation analyze(File file);
}
