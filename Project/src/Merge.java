import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDStream;

import java.awt.*;
import ca.queensu.cs.dal.edfmwk.act.DefaultAction;


public class Merge extends TextAction {
	public Merge() {
		super("Merge");
	}
	public void changeText(TextContents con, int start, int end){
		
		try {
			//Instantiating PDFMergerUtility class
			PDFMergerUtility PDFmerger = new PDFMergerUtility();
			PDDocument doc1 = con.getDoc();
			
			
			FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
		    dialog.setMode(FileDialog.LOAD);
		    dialog.setVisible(true);
		    String fileName = dialog.getDirectory() + dialog.getFile();
		    
		    File file = new File(fileName);
		    PDDocument doc2 = PDDocument.load(file);
		    
		    PDFmerger.appendDocument(doc1, doc2);
			
			//Merging the two documents
			PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
			
			con.setDoc(doc1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
