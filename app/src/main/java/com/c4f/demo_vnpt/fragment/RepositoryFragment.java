package com.c4f.demo_vnpt.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c4f.demo_vnpt.R;

public class RepositoryFragment extends Fragment {
    private static final String TITLE = "title";

    public RepositoryFragment() {
        // Required empty public constructor
    }

    public static RepositoryFragment newInstance(String title) {
        RepositoryFragment fragment = new RepositoryFragment();

        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = view.findViewById(R.id.title);
        tvTitle.setText(getArguments().getString(TITLE));
    }
}
