package linecounter;

import java.io.File;

import javafx.application.Application;

import javax.swing.JOptionPane;

import linecounter.gui.Gui;
import linecounter.logic.SourceContainer;
import linecounter.logic.SourceDirectory;
import linecounter.logic.SourceFile;

public class LineCounter
{
	public static void main(String[] args)
	{
		Application.launch(Gui.class, args);
	}
	
	
	public static void maintest()
	{
		String root = JOptionPane.showInputDialog("Please enter the projects root directory");
		
		if (root == null)
			return;
		File rootFile = new File(root);
		SourceContainer sc = null;
		if (rootFile.isDirectory())
			sc = new SourceDirectory(rootFile);
		else if (rootFile.isFile())
			sc = new SourceFile(rootFile);
		
		JOptionPane.showMessageDialog(null, "Lines:\n\n" + printRecursive(sc));
	}
	
	
	public static String printRecursive(SourceContainer sc)
	{
		System.out.println(sc);
		if (sc instanceof SourceDirectory)
		{
			StringBuilder sb = new StringBuilder();
			for (SourceContainer child : ((SourceDirectory)sc).getChildren())
			{
				sb.append(printRecursive(child));
				sb.append("\n");
			}
			return sc.toString() + ":\n" + sb.toString();
		}
		else if (sc instanceof SourceFile)
		{
			return sc.toString() + ":\t" + sc.getLineCount();
		}
		
		return "";
	}
}
