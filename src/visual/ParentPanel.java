package visual;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import visual.tabs.TrainingPanel;
import visual.tabs.menuPanel.MenuPanel;

@SuppressWarnings("serial")
public class ParentPanel extends JPanel{
	private final String exitStr = "exitStr";
	
	private CardLayout cardLayout;
	final static String TRAINING_PANEL_NAME= "Training Panel";
	final static String MENU_PANEL_NAME= "Menu Panel";
	
	private TrainingPanel trainingPanel;
	private MenuPanel menuPanel;
	
	public ParentPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		trainingPanel = new TrainingPanel(this);
		menuPanel = new MenuPanel(this);
		
		add(trainingPanel, TRAINING_PANEL_NAME);
		add(menuPanel, MENU_PANEL_NAME);
		
		cardLayout.show(this, MENU_PANEL_NAME);
				
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), exitStr);
		getActionMap().put(exitStr, exitAction);
	}

	public void enableTrainingPanel(Object userName){
		cardLayout.show(this, TRAINING_PANEL_NAME);
		trainingPanel.doOnShowing(userName);
	}
		public void enableMenuPanel(){
			cardLayout.show(this, MENU_PANEL_NAME);
		}

	private Action exitAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
}