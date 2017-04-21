package com.animalquiz.moondragon.animalquiz;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final int NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ = 10;

    private List<String> allAnimalsNamesList;
    private List<String> animalsNamesAttendingInQuizList;
    private Set<String>  animalTypesInQuiz;
    private String       correctAnimalsAnswer;
    private int          numberOfAllGuesses;
    private int          numberOfRightAnswers;
    private int          numberOfAnimalsGuessRows;
    private SecureRandom secureRandomNumber;
    private Handler      handler;
    private Animation    wrongAnswerAnimation;

    private LinearLayout animalQuizLinearLayout;
    private TextView     txtQuestionNumber;
    private ImageView    imgAnimal;
    private LinearLayout[] rowsOfGuessButtonsInAnimalQuiz;
    private TextView     txtAnswer;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        allAnimalsNamesList  = new ArrayList<>();
        animalsNamesAttendingInQuizList = new ArrayList<>();
        secureRandomNumber   = new SecureRandom();
        handler              = new Handler();

        wrongAnswerAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.wrong_answer_animation);
        wrongAnswerAnimation.setRepeatCount(1);

        animalQuizLinearLayout            = (LinearLayout) view.findViewById(R.id.animalQuizLinearLayout);
        txtQuestionNumber                 = (TextView) view.findViewById(R.id.txtQuestionNumber);
        imgAnimal                         = (ImageView) view.findViewById(R.id.imgAnimal);
        rowsOfGuessButtonsInAnimalQuiz    = new LinearLayout[3];
        rowsOfGuessButtonsInAnimalQuiz[0] = (LinearLayout) view.findViewById(R.id.rowLnrLayout1);
        rowsOfGuessButtonsInAnimalQuiz[1] = (LinearLayout) view.findViewById(R.id.rowLnrLayout2);
        rowsOfGuessButtonsInAnimalQuiz[2] = (LinearLayout) view.findViewById(R.id.rowLnrLayout3);
        txtAnswer = (TextView) view.findViewById(R.id.txtAnswer);

        for (LinearLayout row : rowsOfGuessButtonsInAnimalQuiz) {
            for (int column = 0; column < row.getChildCount(); column++) {

                Button btnGuess = (Button) row.getChildAt(column);
                btnGuess.setOnClickListener(btnGuessListener);
                btnGuess.setTextSize(24);
            }
        }

        txtQuestionNumber.setText(getString(R.string.question_text, 1, NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ));

        return view;
    }

    private View.OnClickListener btnGuessListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btnGuess = ((Button) view);
            String guessValue = btnGuess.getText().toString();
            String answerValue = getTheExactAnimalName(correctAnimalsAnswer);
            ++numberOfAllGuesses;

            if (guessValue.equals(answerValue)) {
                ++numberOfRightAnswers;
                txtAnswer.setText(answerValue + "!" + " RIGHT");

                disableQuizButtons();

                if (numberOfRightAnswers == NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ) {
                    displaySummaryAndResetDialog();
                } else {
                    displayNextQuestionAnimation();
                }

            } else {
                imgAnimal.startAnimation(wrongAnswerAnimation);

                txtAnswer.setText(R.string.wrong_answer_message);
                btnGuess.setEnabled(false);
            }
        }
    };

    private void displaySummaryAndResetDialog() {
        DialogFragment animalQuizResults = new DialogFragment() {

            @NonNull
            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(getString(R.string.result_string_value, numberOfAllGuesses,
                        (1000/ (double) numberOfAllGuesses)));
                builder.setPositiveButton(R.string.reset_animal_quiz, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetAnimalQuiz();
                    }
                });

                return builder.create();
            }
        };

        animalQuizResults.setCancelable(false);
        animalQuizResults.show(getFragmentManager(), "AnimalQuizResults");
    }

    private void displayNextQuestionAnimation() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animateAnimalQuiz(true);
            }
        }, 1000); // 1000 milliseconds for 1 second delay
    }

    private String getTheExactAnimalName(String animalName) {
        return animalName.substring(animalName.indexOf('-') + 1).replace('_',' ');
    }

    private void disableQuizButtons() {
        for (int row=0; row < numberOfAnimalsGuessRows; row++) {
            LinearLayout guessRowLinearLayout = rowsOfGuessButtonsInAnimalQuiz[row];

            for (int buttonIndex=0; buttonIndex < guessRowLinearLayout.getChildCount(); buttonIndex++) {
                guessRowLinearLayout.getChildAt(buttonIndex).setEnabled(false);
            }
        }
    }

    private void resetAnimalQuiz() {

        AssetManager assets = getActivity().getAssets();
        allAnimalsNamesList.clear();

        try {
            for (String animalType : animalTypesInQuiz) {
                String[] animalsImagePathsInQuiz = assets.list(animalType);

                for (String animalImagePathsInQuiz : animalsImagePathsInQuiz) {
                    allAnimalsNamesList.add(animalImagePathsInQuiz.replace(".png", ""));
                }
            }
        }
        catch (IOException ioEx) {
            Log.e("AnimalQuiz", "Error", ioEx);
        }

        numberOfRightAnswers = 0;
        numberOfAllGuesses   = 0;
        animalsNamesAttendingInQuizList.clear();

        int counter = 1;
        int numberOfAvailableAnimals = allAnimalsNamesList.size();

        while (counter <= NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ) {
            int randomIndex = secureRandomNumber.nextInt(numberOfAvailableAnimals);
            String animalName = allAnimalsNamesList.get(randomIndex);

            if (!animalsNamesAttendingInQuizList.contains(animalName)) {
                animalsNamesAttendingInQuizList.add(animalName);
                ++counter;
            }
        }

        showNextAnimal();
    }

    private void animateAnimalQuiz(boolean animateOutAnimalImage) {
        //incase we are showing the first image, there is no need for an animation
        if (numberOfRightAnswers == 0) {
            return;
        }

        int xTopLeft = 0;
        int yTopLeft = 0;

        int xBottomRight = animalQuizLinearLayout.getLeft() + animalQuizLinearLayout.getRight();
        int yBottomRight = animalQuizLinearLayout.getTop() + animalQuizLinearLayout.getBottom();

        //Here is the max value for radius
        int radius = Math.max(animalQuizLinearLayout.getWidth(), animalQuizLinearLayout.getHeight());

        Animator animator;

        if (animateOutAnimalImage) {
            animator = ViewAnimationUtils.createCircularReveal(animalQuizLinearLayout, xBottomRight, yBottomRight, radius, 0);

            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    showNextAnimal();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            animator = ViewAnimationUtils.createCircularReveal(animalQuizLinearLayout, xTopLeft, yTopLeft, 0, radius);

        }

        animator.setDuration(700);
        animator.start();
    }

    private void showNextAnimal() {
        String nextAnimalImageName = animalsNamesAttendingInQuizList.remove(0);
        correctAnimalsAnswer = nextAnimalImageName;
        txtAnswer.setText("");

        txtQuestionNumber.setText(getString(R.string.question_text, (numberOfRightAnswers + 1), NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ));

        String animalType = nextAnimalImageName.substring(0, nextAnimalImageName.indexOf("-"));

        AssetManager assets = getActivity().getAssets();
        try (InputStream stream = assets.open(animalType + "/" + nextAnimalImageName + ".png")) {
            Drawable animalImage = Drawable.createFromStream(stream, nextAnimalImageName);
            imgAnimal.setImageDrawable(animalImage);

            animateAnimalQuiz(false);

        } catch (IOException ioEx) {
            Log.e("AnimalQuiz", "There is an error Getting" + nextAnimalImageName, ioEx);
        }

        Collections.shuffle(allAnimalsNamesList);

        int correctAnimalNameIndex =  allAnimalsNamesList.indexOf(correctAnimalsAnswer);
        String correctAnimalName = allAnimalsNamesList.remove(correctAnimalNameIndex);
        allAnimalsNamesList.add(correctAnimalName);

        for (int row = 0; row < numberOfAnimalsGuessRows; row++) {
            for (int column = 0 ; column < rowsOfGuessButtonsInAnimalQuiz[row].getChildCount(); column++) {

                Button btnGuess = (Button) rowsOfGuessButtonsInAnimalQuiz[row].getChildAt(column);
                btnGuess.setEnabled(true);

                String animalImageName = allAnimalsNamesList.get((row*2) + column);
                btnGuess.setText(getTheExactAnimalName(animalImageName));
            }
        }

        int row = secureRandomNumber.nextInt(numberOfAnimalsGuessRows);
        int column = secureRandomNumber.nextInt(2);
        LinearLayout randomRow = rowsOfGuessButtonsInAnimalQuiz[row];
        String correctAnimalImageName = getTheExactAnimalName(correctAnimalName);
        ((Button) randomRow.getChildAt(column)).setText(correctAnimalImageName);
    }

    public void ModifyAnimalGuessRows(SharedPreferences sharedPreferences) {
        final String NUMBER_OF_GUESS_OPTIONS = sharedPreferences.getString(MainActivity.GUESSES, null);
        numberOfAnimalsGuessRows = Integer.parseInt(NUMBER_OF_GUESS_OPTIONS) / 2;

        for (LinearLayout horizontalLinearLayout : rowsOfGuessButtonsInAnimalQuiz) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row=0; row < numberOfAnimalsGuessRows; row++) {
            rowsOfGuessButtonsInAnimalQuiz[row].setVisibility(View.VISIBLE);
        }
    }

    public void ModifyTypeOfAnimalsInQuiz(SharedPreferences sharedPreferences) {
        animalTypesInQuiz = sharedPreferences.getStringSet(MainActivity.ANIMALS_TYPES, null);
    }

    public void ModifyQuizFont (SharedPreferences sharedPreferences) {
        String fontStringValue = sharedPreferences.getString(MainActivity.QUIZ_FONT, null);
        Typeface modifiedFont;

        switch (fontStringValue) {

            case "FontleroyBrown.ttf":
                modifiedFont = MainActivity.fontleroybrown;
                break;
            case "Wonderbar Demo.otf":
                modifiedFont = MainActivity.wonderbarDemo;
                break;
            case "Chunkfive.otf":
            default:
                modifiedFont = MainActivity.chinkfive;
                break;
        }

        for(LinearLayout row : rowsOfGuessButtonsInAnimalQuiz) {
            for (int column=0; column < row.getChildCount(); column++) {
                Button button = (Button) row.getChildAt(column);
                button.setTypeface(modifiedFont);
            }
        }
    }

    public void ModifyBackgroundColor(SharedPreferences sharedPreferences) {
        String backgroundColor = sharedPreferences.getString(MainActivity.QUIZ_BACKGROUND_COLOR, null);

        int modifiedBackgroundColor;
        int modifieButtondBackgroundColor;
        int modifiedButtonTextColor;
        int modifiedAnswerTextColor;
        int modifiedQuestionNumberTextColor;

        switch (backgroundColor) {

            case "White":
                modifiedBackgroundColor = Color.WHITE;
                modifieButtondBackgroundColor = Color.BLUE;
                modifiedButtonTextColor = Color.WHITE;
                modifiedAnswerTextColor = Color.BLUE;
                modifiedQuestionNumberTextColor = Color.BLACK;
                break;
            case "Green":
                modifiedBackgroundColor = Color.GREEN;
                modifieButtondBackgroundColor = Color.BLUE;
                modifiedButtonTextColor = Color.WHITE;
                modifiedAnswerTextColor = Color.WHITE;
                modifiedQuestionNumberTextColor = Color.YELLOW;
                break;
            case "Blue":
                modifiedBackgroundColor = Color.BLUE;
                modifieButtondBackgroundColor = Color.RED;
                modifiedButtonTextColor = Color.WHITE;
                modifiedAnswerTextColor = Color.WHITE;
                modifiedQuestionNumberTextColor = Color.WHITE;
                break;
            case "Red":
                modifiedBackgroundColor = Color.RED;
                modifieButtondBackgroundColor = Color.BLUE;
                modifiedButtonTextColor = Color.WHITE;
                modifiedAnswerTextColor = Color.WHITE;
                modifiedQuestionNumberTextColor = Color.WHITE;
                break;
            case "Yellow":
                modifiedBackgroundColor = Color.YELLOW;
                modifieButtondBackgroundColor = Color.BLACK;
                modifiedButtonTextColor = Color.WHITE;
                modifiedAnswerTextColor = Color.BLACK;
                modifiedQuestionNumberTextColor = Color.BLACK;
                break;
            case "Black":
            default:
                modifiedBackgroundColor = Color.BLACK;
                modifieButtondBackgroundColor = Color.YELLOW;
                modifiedButtonTextColor = Color.BLACK;
                modifiedAnswerTextColor = Color.WHITE;
                modifiedQuestionNumberTextColor = Color.WHITE;
                break;

        }

        animalQuizLinearLayout.setBackgroundColor(modifiedBackgroundColor);
        for (LinearLayout row : rowsOfGuessButtonsInAnimalQuiz) {
            for (int column=0; column < row.getChildCount(); column++) {
                Button button = (Button) row.getChildAt(column);
                button.setBackgroundColor(modifieButtondBackgroundColor);
                button.setTextColor(modifiedButtonTextColor);
            }
        }

        txtAnswer.setTextColor(modifiedAnswerTextColor);
        txtQuestionNumber.setTextColor(modifiedQuestionNumberTextColor);

    }
}
