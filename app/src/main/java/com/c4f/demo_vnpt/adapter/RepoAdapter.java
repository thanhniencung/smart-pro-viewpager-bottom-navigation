package com.c4f.demo_vnpt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.c4f.demo_vnpt.R;
import com.c4f.demo_vnpt.model.Repo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<Repo> data = new ArrayList<>();

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

        holder.tvFullName.setText(data.get(position).getFull_name());
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
        }
    }
}
