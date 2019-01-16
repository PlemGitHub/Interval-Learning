package myComponents;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import mech.Constants;
import mech.FileWork;
import visual.tabs.menuPanel.MenuPanel;

public class MyTextField extends JTextField implements Constants{
	private static final long serialVersionUID = 1L;
	
	private final String cancelStr = "Cancel";
	private final String enterStr = "Enter";
	
	private MenuPanel menuPanel;

	public MyTextField(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
		
		setBounds(NEW_USER_TEXTFIELD_RECTANGLE);
		setLocation(NEW_USER_TEXTBOX_POINT);
		setVisible(false);
		
		getInputMap(WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ESCAPE"), cancelStr);
		getActionMap().put(cancelStr, cancelAction);
		
		getInputMap(WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), enterStr);
		getActionMap().put(enterStr, enterAction);
	}
	
	private Action cancelAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {
			menuPanel.enableButtons();
		}
	};
	
	private Action enterAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean nameIsLegal = Pattern.matches("[^\\/:*?\"<>|]*", getText());
			if (nameIsLegal){
				FileWork fileWork = new FileWork();
				if (!fileWork.isAlreadyExists(getText())){
					try {
						fileWork.createNewUser(getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					menuPanel.getUserComboBox().extractUserNamesFromMainFolder();
					menuPanel.getUserComboBox().setSelectedItem(getText());
					menuPanel.enableButtons();
				}else{
					JOptionPane.showMessageDialog(menuPanel, "Current user already exists.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}else{
				JOptionPane.showMessageDialog(menuPanel, "You can't use \\ / : * ? \" < > | symbols.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void showTextField(){
		setVisible(true);
		requestFocus();
	}
	
	public void hideTextField(){
		setText("");
		setVisible(false);
	}
}
