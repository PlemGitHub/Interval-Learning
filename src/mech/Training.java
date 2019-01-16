package mech;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import mech.Card.AnswerQuality;
import visual.tabs.TrainingPanel;

public class Training {
	
	private TrainingPanel trainingPanel;
	private ArrayList<Card> cards;
	private int currentIndex;

	public Training(TrainingPanel trainingPanel, ArrayList<Card> cards) {
		this.trainingPanel = trainingPanel;
		this.cards = cards;
		
		if (checkAnyCardsInDeck()){
			filterCardsToRepeat();
			shuffleCardsToRepeat();
			showNextCard();
		}
	}

	private void filterCardsToRepeat() {
		for (Card card : cards) {
			Calendar today = new GregorianCalendar();
			today.setTimeInMillis(System.currentTimeMillis());
			if (today.getTimeInMillis() < card.getCalendar().getTimeInMillis())
				cards.set(cards.indexOf(card), null);
		}
	}

	private void shuffleCardsToRepeat() {
		for (int i = 0; i < 100; i++) {
			int a = (int)(Math.random()*cards.size());
			int b = (int)(Math.random()*cards.size());
			if (a != b){
				Card temp = cards.get(a);
				cards.set(a, cards.get(b));
				cards.set(b, temp);
			}				
		}
	}

	private boolean checkAnyCardsInDeck() {
		if (cards.size() == 0){
			trainingPanel.setFirstSideText("No cards in deck");
			return false;
		}else
			return true;
	}
	
	private void showNextCard() {
		
	}
	
	public void setAnswerQuality(AnswerQuality answerQuality){
		cards.get(currentIndex).setAnswerQuality(answerQuality);
	}
}
