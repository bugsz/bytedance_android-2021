package com.example.homework2;

import android.graphics.Color;
import android.net.sip.SipSession;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    private List<testData> mDataset = new ArrayList<>();
    private IOnItemClickListener mItemClickListener;

    public myAdapter(List<testData>dataset) {
        mDataset.addAll(dataset);
        Log.d("TAG", "data in myadapter "+mDataset.get(0).Title.toString());
    }

    @Override
    public myAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        Log.d("TAG", mDataset.get(position).toString());
        Log.d("TAG", "position: "+Integer.toString(position));

        holder.onBind(position, mDataset.get(position));
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemClick(position, mDataset.get(position));
                }
            }
        });

        holder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mItemClickListener != null) {
                    mItemClickListener.onItemLongClick(position, mDataset.get(position));
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addData(int position, testData data){
        mDataset.add(position, data);
        notifyItemInserted(position);
        if(position != mDataset.size()) {
            notifyItemRangeChanged(position, mDataset.size() - position);
        }
    }

    public void removeData(int position) {
        if(mDataset != null && position < mDataset.size()){
            mDataset.remove(position);
            notifyItemRemoved(position);
            if(position != mDataset.size()){
                notifyItemRangeChanged(position, mDataset.size() - position);
            }
        }
    }

    public void setOnItemClickListener(IOnItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public interface IOnItemClickListener{
        void onItemClick(int position, testData data);
        void onItemLongClick(int position, testData data);
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView tvIndex;
        private TextView tvHot;
        private TextView tvTitle;
        private View contentView;

        public myViewHolder(View v){
            super(v);
            contentView = v;
            tvIndex = v.findViewById(R.id.tvindex);
            tvHot = v.findViewById(R.id.tvhot);
            tvTitle = v.findViewById(R.id.tvtitle);
        }

        public void onBind(int position, testData data) {
            tvIndex.setText(new StringBuilder().append(position+1).append(". ").toString());
            tvTitle.setText(data.Title);
            tvHot.setText(data.Hot);
            if(position < 3) tvIndex.setTextColor(Color.parseColor("#FFD700"));
            else tvIndex.setTextColor(Color.parseColor("#FFFFFF"));
        }

        public void setOnClickListener(View.OnClickListener listener){
            if(listener != null) contentView.setOnClickListener(listener);
        }

        public void setOnLongClickListener(View.OnLongClickListener listener){
            if(listener != null) contentView.setOnLongClickListener(listener);
        }
    }
}
