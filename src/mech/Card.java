package mech;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Card {
	
	private int number;
	private String dateLine;
	private Calendar calendar = new GregorianCalendar();
	private int repeatPeriod;
	private String firstSide;
	private String secondSide;
	public enum AnswerQuality {FORGOT, REMEMBERED, EASY};
	private AnswerQuality answerQuality;
//	private boolean anyMistakes;
	
	public Card(int number, String dateLine, int repeatPeriod, String russian, String english) {
		this.number = number;
		this.dateLine = dateLine;
			parseDateLineToCalendar();
		this.repeatPeriod = repeatPeriod;
		this.firstSide = russian;
		this.secondSide = english;
//		anyMistakes = false;
	}
	
	private void parseDateLineToCalendar() {
		String[] temp = dateLine.split("\\.");
		int[] tempInt = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			tempInt[i] = Integer.valueOf(temp[i]);
		}
		calendar.set(tempInt[2], tempInt[1], tempInt[0]);
	}

	public int getNumber(){
		return number;
	}
	
	public Calendar getCalendar(){
		return calendar;
	}
	
	public int getRepeatPeriod(){
		return repeatPeriod;
	}
	
	public String getFirstSide(){
		return firstSide;
	}
	
	public String getSecondSide(){
		return secondSide;
	}
	
	public void setAnswerQuality(AnswerQuality answerQuality){
		this.answerQuality = answerQuality;
	}
}
