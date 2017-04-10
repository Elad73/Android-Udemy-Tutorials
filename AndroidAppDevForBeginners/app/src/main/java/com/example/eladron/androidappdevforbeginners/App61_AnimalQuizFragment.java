package com.example.eladron.androidappdevforbeginners;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class App61_AnimalQuizFragment extends Fragment {

    public App61_AnimalQuizFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.app61_animal_quiz_fragment, container, false);
    }
}
