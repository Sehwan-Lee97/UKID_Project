package com.example.ukidapp.ui.StudyImage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.R;
import com.example.ukidapp.ui.home.HomeViewModel;

public class StudyImageFragment extends Fragment {

    private StudyImageViewModel studyImageViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyImageViewModel =
                ViewModelProviders.of(this).get(StudyImageViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study_image, container, false);
        final TextView textView = root.findViewById(R.id.text_study_image);
        studyImageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
