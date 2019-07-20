package com.c4f.demo_vnpt.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c4f.demo_vnpt.R;
import com.c4f.demo_vnpt.adapter.RepoAdapter;
import com.c4f.demo_vnpt.model.Repo;
import com.c4f.demo_vnpt.network.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryFragment extends Fragment {
    private static final String TITLE = "title";
    private RecyclerView recyclerView;
    private RepoAdapter adapter;

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

        recyclerView = view.findViewById(R.id.repoRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RepoAdapter();
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GithubService githubApi = retrofit.create(GithubService.class);

        Call<List<Repo>> call = githubApi.listRepos("thanhniencung");

        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if (response.isSuccessful()) {
                    adapter.setData(response.body());
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                // something went completely south (like no internet connection)
            }
        });
    }
}
