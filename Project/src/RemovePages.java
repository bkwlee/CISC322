import java.io.IOException;
import javax.swing.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import ca.queensu.cs.dal.edfmwk.act.DefaultAction;

public class RemovePages extends TextAction {
	public RemovePages() {
		super("Remove");
	}
	public void changeText(TextContents con, int start, int end){
		try {
			int pages = end - start;
			PDDocument document = con.getDoc();
			//iterate through list of pages to remove, do one at a time
			int pageNum = Integer.parseInt(JOptionPane.showInputDialog("How many pages will you be deleting?",JOptionPane.OK_CANCEL_OPTION));
            for(int i=0; i<pageNum; i++) {
                int numToRemove = Integer.parseInt(JOptionPane.showInputDialog("enter a page to remove"));
                document.removePage(numToRemove % document.getNumberOfPages());
            }
			con.setDoc(document);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
