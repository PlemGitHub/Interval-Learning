package visual.tabs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import mech.Card;
import mech.Card.AnswerQuality;
import mech.Constants;
import mech.FileWork;
import mech.Training;
import myComponents.MyButton;
import myComponents.MyLabel;
import visual.ParentPanel;

@SuppressWarnings("serial")
public class TrainingPanel extends JPanel implements Constants{
	
	private ParentPanel parentPanel;
	private Training training;
	private MyButton finishBtn = new MyButton();
	private MyButton showBtn = new MyButton();
	private ArrayList<Card> cards = new ArrayList<>();
	private MyLabel firstSideLbl = new MyLabel();
	private MyLabel secondSideLbl = new MyLabel();
	//	Card.class: private enum AnswerQuality {FORGOT, REMEMBERED, EASY};
		private MyButton forgotBtn = new MyButton();
		private MyButton rememberedBtn = new MyButton();
		private MyButton easyBtn = new MyButton();
	
	public TrainingPanel(ParentPanel parentPanel) {
		setLayout(null);
		this.parentPanel = parentPanel;
		createComponents();
	}

	private void createComponents() {
		createButtons();
		createLabels();
	}

	private void createButtons() {
		createFinishButton();
		createShowButton();
		createForgotButton();
		createRememberedButton();
		createEasyButton();
	}

		private void createFinishButton() {
			finishBtn.setAction(
					new AbstractAction() {
						private static final long serialVersionUID = 1L;
						@Override
						public void actionPerformed(ActionEvent e) {
							parentPanel.enableMenuPanel();
						}
					}
				);
				finishBtn.setText("Finish");
				finishBtn.setLocation(FINISH_BUTTON_POINT);
				add(finishBtn);
		}

		private void createShowButton() {
			showBtn.setBounds(SHOW_BUTTON_RECTANGLE);
			showBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						showAnswerButtons();
					}
				}
			);
			showBtn.setText("Show answer");
			showBtn.setLocation(SHOW_BUTTON_POINT);
			add(showBtn);
		}

		private void createForgotButton() {
			forgotBtn.setBounds(BUTTON_RECTANGLE);
			forgotBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						hideAnswerButtons();
						training.setAnswerQuality(AnswerQuality.FORGOT);
					}
				}
			);
			forgotBtn.setText("Forgot");
			forgotBtn.setLocation(FORGOT_BUTTON_POINT);
			forgotBtn.setBackground(Color.RED);
			forgotBtn.setVisible(false);
			add(forgotBtn);
		}

		private void createRememberedButton() {
			rememberedBtn.setBounds(BUTTON_RECTANGLE);
			rememberedBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						hideAnswerButtons();	
						training.setAnswerQuality(AnswerQuality.REMEMBERED);					
					}
				}
			);
			rememberedBtn.setText("Remembered");
			rememberedBtn.setLocation(REMEMBERED_BUTTON_POINT);
			rememberedBtn.setBackground(Color.YELLOW);
			rememberedBtn.setVisible(false);
			add(rememberedBtn);
		}

		private void createEasyButton() {
			easyBtn.setBounds(BUTTON_RECTANGLE);
			easyBtn.setAction(
				new AbstractAction() {
					private static final long serialVersionUID = 1L;
					@Override
					public void actionPerformed(ActionEvent e) {
						hideAnswerButtons();
						training.setAnswerQuality(AnswerQuality.EASY);
					}
				}
			);
			easyBtn.setText("Easy");
			easyBtn.setLocation(EASY_BUTTON_POINT);
			easyBtn.setVisible(false);
			add(easyBtn);
		}

	private void createLabels() {
		firstSideLbl.setLocation(FIRST_SIDE_POINT);
		secondSideLbl.setLocation(SECOND_SIDE_POINT);
		
		add(firstSideLbl);
		add(secondSideLbl);
	}
	
	public void doOnShowing(Object userName){
		FileWork fileWork = new FileWork();
		try {
			training = new Training(this, fileWork.extractCardsFromFile(userName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setFirstSideText(String text){
		firstSideLbl.setText(text);
	}
	
	public void setSecondSideText(String text){
		secondSideLbl.setText(text);
	}
	
	public void showAnswerButtons(){
		forgotBtn.setVisible(true);
		rememberedBtn.setVisible(true);
		easyBtn.setVisible(true);
		showBtn.setVisible(false);
	}
			
	public void hideAnswerButtons(){
		forgotBtn.setVisible(false);
		rememberedBtn.setVisible(false);
		easyBtn.setVisible(false);
		showBtn.setVisible(true);
	}
}
