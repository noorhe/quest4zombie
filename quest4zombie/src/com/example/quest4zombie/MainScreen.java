package com.example.quest4zombie;

import java.util.ArrayList;

import com.example.quest4zombie.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainScreen extends Activity {
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		context = getApplicationContext();
		drawMainScreen();
	}

	private void drawMainScreen() {
    	LinearLayout mainLayout = createMainLayout(context);
    	
    	TextView titleTextView = createTitle(context);
    	mainLayout.addView(titleTextView);
    	
        ArrayList<Button> buttons = createButtons(context);
        for(Button button : buttons){
        	mainLayout.addView(button);
        }
        
        setContentView(mainLayout);
	}
	
	
	private TextView createTitle(Context context) {
		TextView titleTextView = new TextView(context);
		titleTextView.setText("quest4Zombie");
		return titleTextView;
	}

	private LinearLayout createMainLayout(Context context2) {
		LinearLayout mainLayout = new LinearLayout(this.context);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
		return mainLayout;
	}

	ArrayList<Button> createButtons(Context context){
		ArrayList<Button> buttons = new ArrayList<Button>();
		
        Button startNewGameButton = new Button(context);
        startNewGameButton.setText("Начать заново");
        
        Button continueGameButton = new Button(context);
        continueGameButton.setText("Продолжить");
        
        Button quitButton = new Button(context);
        quitButton.setText("Уходим");
        
        buttons.add(startNewGameButton);
        buttons.add(continueGameButton);
        buttons.add(quitButton);
        return buttons;
	}
}
