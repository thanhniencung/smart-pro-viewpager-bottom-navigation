package com.c4f.demo_vnpt.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.c4f.demo_vnpt.R;
import com.c4f.demo_vnpt.WebActivity;
import com.c4f.demo_vnpt.model.Repo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// this is zzzz
public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<Repo> data = new ArrayList<>();
    private FragmentActivity activity;

    public RepoAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    public void setData(List<Repo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_repo, parent, false);
        return new RepoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {

        Picasso.get()
                .load(data.get(position).getOwner().getAvatar_url())
                .into(holder.ivAvatar);

        holder.tvFullName.setText(data.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvFullName;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.avatar);
            tvFullName = itemView.findViewById(R.id.fullName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Repo repo = data.get(getAdapterPosition());

                    Intent intent = new Intent(activity, WebActivity.class);
                    intent.putExtra("WEB_URL", repo.getHtmlUrl());
                    intent.putExtra("TITLE", repo.getFullName());
                    activity.startActivity(intent);
                }
            });
        }
    }
}
