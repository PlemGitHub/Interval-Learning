package visual.tabs.menuPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import mech.Constants;
import mech.FileWork;
import myComponents.MyButton;
import myComponents.MyLabel;
import myComponents.MyTextField;
import visual.ParentPanel;
import visual.tabs.menuPanel.elements.UserComboBox;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements Constants{
	
	private UserComboBox userComboBox = new UserComboBox(this);
	private MyButton newUserBtn = new MyButton();
	private MyButton deleteUserBtn = new MyButton();
	private MyButton startBtn = new MyButton();
	private MyTextField newUserTextField;
	private ParentPanel parentPanel;
	private MyLabel infoTotalLbl = new MyLabel();
	private MyLabel infoRepeatLbl = new MyLabel();
	
	public MenuPanel(ParentPanel parentPanel) {
		this.parentPanel = parentPanel;
		setLayout(null);
		createComponents();
	}

	private void createComponents() {
		add(userComboBox);
		createNewUserTextBox();
		createButtons();
		createLabels();
	}

	private void createNewUserTextBox() {
		newUserTextField = new MyTextField(this);
		add(newUserTextField);
	}

	private void createButtons() {
		createNewUserButton();
		createDeleteUserButton();
		createStartButton();
		disableButtonsIfZeroItemsInUserComboBox();
	}

		private void createNewUserButton() {
			newUserBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						disableButtons();
					}
				}
			);
			newUserBtn.setText("New User");
			newUserBtn.setLocation(NEW_USER_BUTTON_POINT);
			add(newUserBtn);
		}

		private void createDeleteUserButton() {
			deleteUserBtn.setAction(
					new AbstractAction() {
						private static final long serialVersionUID = 1L;
						@Override
						public void actionPerformed(ActionEvent e) {
							FileWork fileWork = new FileWork();
							fileWork.deletUser((String)userComboBox.getSelectedItem());
							userComboBox.extractUserNamesFromMainFolder();
							disableButtonsIfZeroItemsInUserComboBox();
						}
					}
			);
			deleteUserBtn.setText("Delete User");
			deleteUserBtn.setBackground(Color.RED);
			deleteUserBtn.setLocation(DELETE_USER_BUTTON_POINT);
			add(deleteUserBtn);
		}
	
		private void createStartButton() {
			startBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						parentPanel.enableTrainingPanel(userComboBox.getSelectedItem());
					}
				}
			);
			startBtn.setText("Start");
			startBtn.setLocation(START_BUTTON_POINT);
			add(startBtn);
		}

	private void disableButtonsIfZeroItemsInUserComboBox() {
		if (userComboBox.getItemCount() == 0){
			userComboBox.setEnabled(false);
			startBtn.setEnabled(false);
			deleteUserBtn.setEnabled(false);
			startBtn.setEnabled(false);
		}
	}

	private void createLabels() {
		createInfoTotalLabel();
		createInfoRepeatLabel();
		if (userComboBox.getItemCount() != 0)
			userComboBox.extractDataForLabels();
	}
	
		private void createInfoTotalLabel() {
			infoTotalLbl.setBounds(INFO_LABEL_RECTANGLE);
			infoTotalLbl.setLocation(INFO_TOTAL_POINT);
			add(infoTotalLbl);
		}

		private void createInfoRepeatLabel() {
			infoRepeatLbl.setBounds(INFO_LABEL_RECTANGLE);
			infoRepeatLbl.setLocation(INFO_REPEAT_POINT);
			add(infoRepeatLbl);
		}

		public MyTextField getNewUserTextField(){
			return newUserTextField;
		}
	
		public MyButton getNewUserButton(){
			return newUserBtn;
		}
		
		public UserComboBox getUserComboBox(){
			return userComboBox;
		}
	
	public void enableButtons(){
		newUserBtn.setEnabled(true);
		if (userComboBox.getItemCount() != 0){
			startBtn.setEnabled(true);
			deleteUserBtn.setEnabled(true);
			userComboBox.setEnabled(true);
		}
		newUserTextField.hideTextField();
	}
	
	public void disableButtons(){
		newUserBtn.setEnabled(false);
		deleteUserBtn.setEnabled(false);
		startBtn.setEnabled(false);
		userComboBox.setEnabled(false);
		newUserTextField.showTextField();
	}
	
	public void setInfoTotalLabelText(String text){
		infoTotalLbl.setText(text);
	}
	
		public void setInfoRepeatLabelText(String text){
			infoRepeatLbl.setText(text);
		}
		
			public void clearInfoLabels(){
				infoTotalLbl.setText("");
				infoRepeatLbl.setText("");
			}
}
