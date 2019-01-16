package visual.tabs.menuPanel.elements;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import mech.Card;
import mech.Constants;
import mech.FileWork;
import visual.tabs.menuPanel.MenuPanel;

public class UserComboBox extends JComboBox<String> implements Constants, ItemListener{
	private static final long serialVersionUID = 1L;
	
	private MenuPanel menuPanel;
	
	public UserComboBox(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
		setBounds(USER_COMBO_BOX_RECTANGLE);
		setLocation(USER_COMBO_BOX_POINT);
		((JLabel)getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		extractUserNamesFromMainFolder();
		addItemListener(this);
	}

	private Object makeObj(final String item){
	     return new Object() {
	    	 public String toString(){
	    		 return item.substring(0, item.length()); 
	    	 }
	     };
	}
	
	public void extractUserNamesFromMainFolder(){
		removeAllItems();
		FileWork fileWork = new FileWork();
		ArrayList<String> usersList = new ArrayList<>();
		usersList = fileWork.getUsersList();
			for (int i = 0; i < usersList.size(); i+=1) {
				addItem(makeObj(usersList.get(i)).toString());
			}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (getItemCount() == 0){
			menuPanel.clearInfoLabels();
		}else{
			extractDataForLabels();		
		}
	}

		public void extractDataForLabels() {
			String userName = (String)getSelectedItem();
			FileWork fileWork = new FileWork();
			ArrayList<Card> cards = new ArrayList<>();
			try {
				cards = fileWork.extractCardsFromFile(userName);
			} catch (IOException e1) {e1.printStackTrace();}
			menuPanel.setInfoTotalLabelText("Total cards: "+ cards.size());
			menuPanel.setInfoRepeatLabelText("Cards to repeat: ");	
		}
}
