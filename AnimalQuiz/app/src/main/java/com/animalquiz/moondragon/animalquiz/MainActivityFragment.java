package com.animalquiz.moondragon.animalquiz;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
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
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final int NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ = 10;

    private SecureRandom secureRandomNumber;
    private Handler      handler;
    private Animation    wrongAnswerAnimation;

    private LinearLayout animalQuizLinearLayout;
    private TextView     txtQuestionNumber;
    private ImageView    imgAnimal;
    private LinearLayout[] rowsOfGuessButtonsInAnimalQuiz;
    private TextView     txtAnswer;

    private QuizData     quizData;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        quizData = new QuizData();
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
                btnGuess.setTextSize(quizData.getDefaultTextSize());
            }
        }

        txtQuestionNumber.setText(getString(R.string.question_text, 1, quizData.getNumberOfAnimalsIncludedInRound()));

        return view;
    }

    private View.OnClickListener btnGuessListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btnGuess = ((Button) view);
            String guessValue = btnGuess.getText().toString();
            String answerValue =  quizData.getCurrentRightAnswer().getName();
            quizData.incrementRoundAttempts();

            if (guessValue.equals(answerValue)) {
                //++numberOfRightAnswers;
                quizData.incrementSuccessfullAttempts();
                txtAnswer.setText(answerValue + "!" + " RIGHT");

                disableQuizButtons();

                if (quizData.getNumberOfSuccessfulAnswers() == NUMBER_OF_ANIMALS_INCLUDED_IN_QUIZ) {
                    displayStaticSummaryAndResetDialog();
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


    public static class MyAlertDialogFragment extends DialogFragment {

        public static MyAlertDialogFragment newInstance(int numOfAllGuesses) {

            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("NumOfAllGuesses", numOfAllGuesses);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int numOfAllGuesses = getArguments().getInt("NumOfAllGuesses");
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.summary_dialog_title);
            Resources res = getResources();
            builder.setMessage(res.getQuantityString(R.plurals.result_string_value, numOfAllGuesses, numOfAllGuesses,
                    (1000/ (double) numOfAllGuesses)));
            builder.setPositiveButton(R.string.reset_animal_quiz, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ((MainActivityFragment) getFragmentManager().findFragmentById(R.id.animalQuizFragment)).resetAnimalQuiz();
                }
            });

            return builder.create();
        }

    }

    private void displayStaticSummaryAndResetDialog() {

        MyAlertDialogFragment animalQuizResults = MyAlertDialogFragment.newInstance(quizData.getNumberOfGuessesInRound());
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

    private void disableQuizButtons() {
        for (int row=0; row < quizData.getNumberOfGuessesRowsInRound(); row++) {
            LinearLayout guessRowLinearLayout = rowsOfGuessButtonsInAnimalQuiz[row];

            for (int buttonIndex=0; buttonIndex < guessRowLinearLayout.getChildCount(); buttonIndex++) {
                guessRowLinearLayout.getChildAt(buttonIndex).setEnabled(false);
            }
        }
    }

    private void animateAnimalQuiz(boolean animateOutAnimalImage) {
        //incase we are showing the first image, there is no need for an animation
        if (quizData.getNumberOfSuccessfulAnswers() == 0) {
            return;
        }

        int xTopLeft = 0;
        int yTopLeft = 0;

        int xBottomRight = animalQuizLinearLayout.getLeft() + animalQuizLinearLayout.getRight();
        int yBottomRight = animalQuizLinearLayout.getTop() + animalQuizLinearLayout.getBottom();

        //Here is the max value for radius
        int radius = Math.max(animalQuizLinearLayout.getWidth(), animalQuizLinearLayout.getHeight());

        Animator animator;

        //since "createCircularReveal" works from sdk 21 and up.
        //otherwise, there will not be an animation
        if (Build.VERSION.SDK_INT >= 21 ) {
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
    }

    private void showNextAnimal() {
        Animal correctAnimal = quizData.getNextAnimalInRound();
        txtAnswer.setText("");

        txtQuestionNumber.setText(getString(R.string.question_text, (quizData.getNumberOfSuccessfulAnswers() + 1), quizData.getNumberOfAnimalsIncludedInRound()));
        String animalType = correctAnimal.getType();

        AssetManager assets = getActivity().getAssets();
        try (InputStream stream = assets.open(correctAnimal.getImagePath())) {
            Drawable animalImage = Drawable.createFromStream(stream, correctAnimal.getType());
            imgAnimal.setImageDrawable(animalImage);

            animateAnimalQuiz(false);

        } catch (IOException ioEx) {
            Log.e("AnimalQuiz", "There is an error Getting" + correctAnimal.getImagePath(), ioEx);
        }

        List<String> currentWrongGuesses = quizData.getCurrentWrongGuesses();

        for (int row = 0; row < quizData.getNumberOfGuessesRowsInRound(); row++) {
            for (int column = 0 ; column < rowsOfGuessButtonsInAnimalQuiz[row].getChildCount(); column++) {

                Button btnGuess = (Button) rowsOfGuessButtonsInAnimalQuiz[row].getChildAt(column);
                btnGuess.setEnabled(true);

                String animalImageName = currentWrongGuesses.get((row*2) + column);
                btnGuess.setText(animalImageName);
            }
        }

        int row = secureRandomNumber.nextInt(quizData.getNumberOfGuessesRowsInRound());
        int column = secureRandomNumber.nextInt(2);
        LinearLayout randomRow = rowsOfGuessButtonsInAnimalQuiz[row];
        ((Button) randomRow.getChildAt(column)).setText(correctAnimal.getName());
    }

    public void resetAnimalQuiz() {

        quizData.prepareNewRound();
        showNextAnimal();
    }

    public void loadRoundGuessRows(SharedPreferences sharedPreferences) {
        quizData.loadNumberOfGuesses(Short.parseShort(sharedPreferences.getString(MainActivity.GUESSES, null)));

        for (LinearLayout horizontalLinearLayout : rowsOfGuessButtonsInAnimalQuiz) {
            horizontalLinearLayout.setVisibility(View.GONE);
        }

        for (int row=0; row < quizData.getNumberOfGuessesRowsInRound(); row++) {
            rowsOfGuessButtonsInAnimalQuiz[row].setVisibility(View.VISIBLE);
        }
    }

    public void modifyTypeOfAnimalsInQuiz(SharedPreferences sharedPreferences) {
        //animalTypesInQuiz = sharedPreferences.getStringSet(MainActivity.ANIMALS_TYPES, null);
        quizData.loadAnimalTypesInRound(sharedPreferences.getStringSet(MainActivity.ANIMALS_TYPES, null));
    }

    public void modifyQuizFont(SharedPreferences sharedPreferences) {
        String fontStringValue = sharedPreferences.getString(MainActivity.QUIZ_FONT, null);
        Typeface modifiedFont;
        float fontSize = 24;

        switch (fontStringValue) {

            case "BoyzRGrossNF.ttf":
                modifiedFont = MainActivity.boyzRGrossNF;
                fontSize = 34;
                break;
            case "Chubby Dotty.ttf":
                modifiedFont = MainActivity.chubbyDotty;
                fontSize = 30;
                break;
            case "Love Letters.ttf":
                modifiedFont = MainActivity.loveLetters;
                fontSize = 36;
                break;
            case "EmilysCandy-Regular.ttf":
            default:
                modifiedFont = MainActivity.emilysCandyRegular;
                fontSize = 24;
                break;
        }

        for(LinearLayout row : rowsOfGuessButtonsInAnimalQuiz) {
            for (int column=0; column < row.getChildCount(); column++) {
                Button button = (Button) row.getChildAt(column);
                button.setTypeface(modifiedFont);
                button.setTextSize(fontSize);
            }
        }
    }

    public void modifyBackgroundColor(SharedPreferences sharedPreferences) {
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

    public void initializeFragment(SharedPreferences sharedPreferences) {

        AssetManager assets = getActivity().getAssets();

        quizData.initializeData(assets, sharedPreferences.getStringSet(MainActivity.ANIMALS_TYPES, null));
        loadRoundGuessRows(sharedPreferences);
        modifyQuizFont(sharedPreferences);
        modifyBackgroundColor(sharedPreferences);
        resetAnimalQuiz();
    }
}
