import java.io.*;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
// Import only those classes from edfmwk that are essential, for documentation purposes
import ca.queensu.cs.dal.edfmwk.Application;
import ca.queensu.cs.dal.edfmwk.act.AboutAction;
import ca.queensu.cs.dal.edfmwk.act.CreditAction;
import ca.queensu.cs.dal.edfmwk.act.DefaultAction;
import ca.queensu.cs.dal.edfmwk.act.HelpAction;
import ca.queensu.cs.dal.edfmwk.act.NewAction;
import ca.queensu.cs.dal.edfmwk.doc.DocumentType;
import ca.queensu.cs.dal.edfmwk.doc.DocumentManager;
import ca.queensu.cs.dal.edfmwk.i18n.Localizers;
import ca.queensu.cs.dal.edfmwk.menu.MenuDescriptor;
import ca.queensu.cs.dal.edfmwk.menu.MenuElement;
import ca.queensu.cs.dal.edfmwk.Menus;
import ca.queensu.cs.dal.flex.Register;
import ca.queensu.cs.dal.flex.i18n.Localizer;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.*;


public class Main {

	public static void main(String[] args) throws IOException{
		
		//Creating PDF document object
		File file = new File("./files/EditorFramework.pdf");
		PDDocument doc = PDDocument.load(file);
		
		PDFTextStripper pdfStripper = new PDFTextStripper();
		
		String text = pdfStripper.getText(doc);
		System.out.println(text);
		
		doc.close();
		
		new TextEditor();

	}

}
