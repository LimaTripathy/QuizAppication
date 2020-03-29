package com.example.quizappication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizappication.models.Questions;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {
    Context mCtx;
    List<Questions> results;

    public ResultAdapter(Context mCtx, List<Questions> results) {
        this.mCtx = mCtx;
        this.results = results;
    }
    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_layout, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Questions result = results.get(position);
        holder.textView.setText("Q :"+result.getQuestion());
        if (result.isCorrect()){
            holder.textView2.setTextColor(Color.GREEN);
            holder.textView2.setText("A : Correct");
        }else {
            holder.textView2.setTextColor(Color.RED);
            holder.textView2.setText("A : Wrong");
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);

            textView2 = itemView.findViewById(R.id.textView2);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
