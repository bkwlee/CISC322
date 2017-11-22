import java.awt.FileDialog;

import javax.swing.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import java.awt.*;


public class EncryptPDF extends TextAction {
	
	public EncryptPDF() {
		super("Encrypt");
	}
	
	public void changeText(TextContents con, int start, int end) {
		try {
			// Set encryption to 128-bit 
			int keyLength = 128;
			// Load document from parameter
			PDDocument doc = con.getDoc();
			
			AccessPermission ap = new AccessPermission();
			// Disable printing (PoC for encryption)
			ap.setCanPrint(false);
			
			// Grab two passwords from the user
			// One as an all-access pass
			// The other as a restricted access enabler
			String unrestricted = JOptionPane.showInputDialog("Password with for all permissions");
			String restricted = JOptionPane.showInputDialog("Password for restricted access:");
			//Set passwords & encryption key length & restrictions to file
			StandardProtectionPolicy spp = new StandardProtectionPolicy(unrestricted, restricted, ap);
			spp.setEncryptionKeyLength(keyLength);
			spp.setPermissions(ap);
			doc.protect(spp);
			
			// Save the file to another, SECURE location
			FileDialog dialog = new FileDialog((Frame)null, "Select File to Save to");
			dialog.setMode(FileDialog.SAVE);
			dialog.setVisible(true);
			String fileName = dialog.getDirectory() + dialog.getFile() + ".pdf";
			
			doc.save(fileName);
			
			con.setDoc(doc);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
