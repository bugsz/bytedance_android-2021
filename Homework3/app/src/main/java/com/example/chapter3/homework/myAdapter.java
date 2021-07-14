package com.example.chapter3.homework;

import android.graphics.Color;
import android.media.Image;
import android.net.sip.SipSession;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    private List<testData> mDataset = new ArrayList<>();
    private IOnItemClickListener mItemClickListener;

    public myAdapter(List<testData>dataset) {
        mDataset.addAll(dataset);
    }

    @Override
    public myAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new myViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        // Log.d("TAG", mDataset.get(position).toString());
        // Log.d("TAG", "position: "+Integer.toString(position));

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
        private TextView friendName;
        private TextView friendTime;
        private TextView friendText;
        private ImageView friendAvatar;
        private View contentView;

        public myViewHolder(View v){
            super(v);
            contentView = v;
            friendName = v.findViewById(R.id.friend_name);
            friendText = v.findViewById(R.id.friend_text);
            friendTime = v.findViewById(R.id.friend_time);
            friendAvatar = v.findViewById(R.id.avatar);
        }

        public void onBind(int position, testData data) {
            friendName.setText(data.Name);

            SimpleDateFormat ft = new SimpleDateFormat ("hh:mm");
            String time = ft.format(data.Time);
            friendText.setText(data.Text + " . " + time);
            friendTime.setText(time);

            int avatarID = getAvatarId(data.id);
            friendAvatar.setImageResource(avatarID);
        }

        public void setOnClickListener(View.OnClickListener listener){
            if(listener != null) contentView.setOnClickListener(listener);
        }

        public void setOnLongClickListener(View.OnLongClickListener listener){
            if(listener != null) contentView.setOnLongClickListener(listener);
        }

        public int getAvatarId(int uId) {
            Class mipmap = R.mipmap.class;
            try{
                Field field = mipmap.getField("avatar_"+uId);
                int resId = field.getInt("avatar_"+uId);
                return resId;
            }catch(NoSuchFieldException e){
                return 0;
            }catch(IllegalAccessException e){
                return 0;
            }
        }
    }
}
