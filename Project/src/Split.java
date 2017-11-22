import java.io.File;
import java.io.IOException;
import javax.swing.*;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDStream;
import java.util.List;
import java.util.Iterator;
import java.awt.*;
import ca.queensu.cs.dal.edfmwk.act.DefaultAction;

public class Split extends TextAction{
	public Split() {
		super("Split");
	}
	public void changeText(TextContents con, int start, int end){
		
		try {
			PDDocument doc = con.getDoc();
		    
			Splitter split = new Splitter();
			
			List<PDDocument> Pages = split.split(doc);
			
			Iterator<PDDocument> iter = Pages.listIterator();
			
			int i = 1;
		    while(iter.hasNext()) {
		    	PDDocument pd = iter.next();
		    	pd.save("MyPdf"+ i++ +".pdf");
		    }
			
			con.setDoc(doc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
