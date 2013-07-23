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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainScreen extends Activity {
    private final String QUIT = "Начать новую";
    private final String CONTINUE = "Продолжить";
    private final String START_NEW = "Выход";
    private Context context;
    private final int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        context = getApplicationContext();
        drawMainScreen();
    }

    private void drawMainScreen() {
        LinearLayout mainLayout = createMainLayout(context);

        TextView titleTextView = createTitle(context);
        titleTextView.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams mainLayoutTitleParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, 0.3f);
        mainLayout.addView(titleTextView, mainLayoutTitleParams);

        ArrayList<Button> buttons = createButtons(context);
        ArrayList<FrameLayout> wrappedButtons = wrapButtons(context, buttons);
        LinearLayout.LayoutParams mainLayoutButtonParams = new LinearLayout.LayoutParams(
                WRAP_CONTENT, WRAP_CONTENT, 0.2f);
        for (FrameLayout wrappedButton : wrappedButtons) {
            mainLayout.addView(wrappedButton, mainLayoutButtonParams);
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
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        return mainLayout;
    }

    ArrayList<Button> createButtons(Context context) {
        ArrayList<Button> buttons = new ArrayList<Button>();
        LayoutParams buttomParams = new LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        Button startNewGameButton = new Button(context);
        startNewGameButton.setText(START_NEW);
        startNewGameButton.setGravity(Gravity.CENTER);
        startNewGameButton.setLayoutParams(buttomParams);

        Button continueGameButton = new Button(context);
        continueGameButton.setText(CONTINUE);
        continueGameButton.setGravity(Gravity.CENTER);
        continueGameButton.setLayoutParams(buttomParams);

        Button quitButton = new Button(context);
        quitButton.setText(QUIT);
        quitButton.setGravity(Gravity.CENTER);
        quitButton.setLayoutParams(buttomParams);


        buttons.add(startNewGameButton);
        buttons.add(continueGameButton);
        buttons.add(quitButton);
        return buttons;
    }

    ArrayList<FrameLayout> wrapButtons(Context context,
            ArrayList<Button> buttons) {
        ArrayList<FrameLayout> wrappingLayouts = new ArrayList<FrameLayout>();
        for (Button button : buttons) {
            FrameLayout wrappingFrameLayout = new FrameLayout(context);
            wrappingFrameLayout.addView(button);
            wrappingLayouts.add(wrappingFrameLayout);
        }
        return wrappingLayouts;
    }
}
