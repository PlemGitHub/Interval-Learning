package mech;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
public interface Constants {
	
////////// GENERAL //////////
	int WINDOW_WIDTH = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	int WINDOW_HEIGHT = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	int CENTER_WIDTH = WINDOW_WIDTH/2;
	
	int ELEMENT_HEIGHT = WINDOW_HEIGHT / 10;
	int ELEMENT_WIDTH = ELEMENT_HEIGHT * 3;
	
////////// MENU PANEL //////////
	int USER_COMBO_BOX_WIDTH = ELEMENT_WIDTH;
	int USER_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;
		Rectangle USER_COMBO_BOX_RECTANGLE = new Rectangle(USER_COMBO_BOX_WIDTH, USER_COMBO_BOX_HEIGHT);
			Point USER_COMBO_BOX_POINT = new Point(CENTER_WIDTH-USER_COMBO_BOX_WIDTH/2, 0);
	
	int BUTTON_WIDTH = ELEMENT_WIDTH/2;
	int BUTTON_HEIGHT = ELEMENT_HEIGHT/2;
		Rectangle BUTTON_RECTANGLE = new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT);
			Point NEW_USER_BUTTON_POINT = new Point(CENTER_WIDTH-BUTTON_WIDTH/2, USER_COMBO_BOX_HEIGHT);
			Point DELETE_USER_BUTTON_POINT = new Point(NEW_USER_BUTTON_POINT.x-BUTTON_WIDTH, USER_COMBO_BOX_HEIGHT);
			Point START_BUTTON_POINT = new Point(CENTER_WIDTH-BUTTON_WIDTH/2, USER_COMBO_BOX_HEIGHT+BUTTON_HEIGHT);
	
	Rectangle NEW_USER_TEXTFIELD_RECTANGLE = new Rectangle(ELEMENT_WIDTH, ELEMENT_HEIGHT/2);
		Point NEW_USER_TEXTBOX_POINT = new Point(CENTER_WIDTH+BUTTON_WIDTH/2, USER_COMBO_BOX_HEIGHT);
	
	int INFO_LABEL_WIDTH = ELEMENT_WIDTH*2;
	int INFO_LABEL_HEIGHT = ELEMENT_HEIGHT;
		Rectangle INFO_LABEL_RECTANGLE = new Rectangle(INFO_LABEL_WIDTH, INFO_LABEL_HEIGHT);
			Point INFO_TOTAL_POINT = new Point(CENTER_WIDTH-INFO_LABEL_WIDTH/2, START_BUTTON_POINT.y+BUTTON_HEIGHT);
			Point INFO_REPEAT_POINT = new Point(CENTER_WIDTH-INFO_LABEL_WIDTH/2, INFO_TOTAL_POINT.y+INFO_LABEL_HEIGHT);
	
////////// TRAINING PANEL //////////
	Point FINISH_BUTTON_POINT = new Point(CENTER_WIDTH-BUTTON_WIDTH/2, 0);
	
	int SIDE_WIDTH = CENTER_WIDTH;
	int SIDE_HEIGHT = WINDOW_HEIGHT-BUTTON_HEIGHT*3;
		Rectangle SIDE_RECTANGLE = new Rectangle(SIDE_WIDTH, SIDE_HEIGHT);
	
			Point FIRST_SIDE_POINT = new Point(0, BUTTON_HEIGHT);
			Point SECOND_SIDE_POINT = new Point(SIDE_WIDTH, BUTTON_HEIGHT);
	
	Rectangle SHOW_BUTTON_RECTANGLE = new Rectangle(ELEMENT_WIDTH, ELEMENT_HEIGHT);
		Point SHOW_BUTTON_POINT = new Point(SECOND_SIDE_POINT.x+SIDE_WIDTH/2-ELEMENT_WIDTH/2, 
											SECOND_SIDE_POINT.y+SIDE_HEIGHT/2-ELEMENT_HEIGHT/2);
		
	int ANSWER_BUTTONS_Y = FIRST_SIDE_POINT.y+SIDE_HEIGHT;
	int REMEMBERED_BUTTON_X = CENTER_WIDTH-BUTTON_WIDTH/2;
	int FORGOT_BUTTON_X = REMEMBERED_BUTTON_X-BUTTON_WIDTH;
	int EASY_BUTTON_X = REMEMBERED_BUTTON_X+BUTTON_WIDTH;
		Point FORGOT_BUTTON_POINT = new Point(FORGOT_BUTTON_X, ANSWER_BUTTONS_Y);
		Point REMEMBERED_BUTTON_POINT = new Point(REMEMBERED_BUTTON_X, ANSWER_BUTTONS_Y);
		Point EASY_BUTTON_POINT = new Point(EASY_BUTTON_X, ANSWER_BUTTONS_Y);
		
}
