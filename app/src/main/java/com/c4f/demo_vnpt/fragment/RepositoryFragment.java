package com.c4f.demo_vnpt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.c4f.demo_vnpt.R;
import com.c4f.demo_vnpt.adapter.RepoAdapter;
import com.c4f.demo_vnpt.model.Repo;
import com.c4f.demo_vnpt.network.GithubService;
import com.c4f.demo_vnpt.network.RestCallback;
import com.c4f.demo_vnpt.network.model.RestError;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryFragment extends Fragment {
    private static final String TITLE = "title";
    private RecyclerView recyclerView;
    private RepoAdapter adapter;
    private ProgressBar progressBar;

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
        return inflater.inflate(R.layout.fragment_repo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress);
        recyclerView = view.findViewById(R.id.repoRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RepoAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        GithubService.get().listRepos("thanhniencung")

                .enqueue(new RestCallback<List<Repo>>() {
                    @Override
                    public void onSuccess(List<Repo> data) {
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        adapter.setData(data);
                    }

                    @Override
                    public void onFailure(RestError restError) {

                    }
                });
    }
}
