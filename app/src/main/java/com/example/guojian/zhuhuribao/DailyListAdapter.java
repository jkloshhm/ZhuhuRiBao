package com.example.guojian.zhuhuribao;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guojian.zhuhuribao.bean.DailyListBean;
import com.example.guojian.zhuhuribao.util.LogToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guojian on 2017/5/19.
 */

public class DailyListAdapter extends RecyclerView.Adapter<DailyListAdapter.MyViewHolder> {

    private Context mContext;
    private List<DailyListBean.StoriesBean> mStoriesBeanList;

    public DailyListAdapter(List<DailyListBean.StoriesBean> dailyListBeen) {
        this.mStoriesBeanList = dailyListBeen;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fruit_image)
        ImageView fruitImage;
        @BindView(R.id.fruit_name)
        TextView fruitName;
        private CardView mCardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mCardView = (CardView) itemView;
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, parent, false);
        //View view = LayoutInflater.from(mContext).inflate(R.layout.news_item, null);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myViewHolder.getAdapterPosition();
                int id = mStoriesBeanList.get(position).getId();
                LogToastUtils.showShort(mContext,""+id);
                Intent mIntent = new Intent(mContext,DailyDetailActivity.class);
                mIntent.putExtra("newsId",id);
                //mIntent.putExtra("body",mStoriesBeanList.get(position).get);
                mContext.startActivity(mIntent);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DailyListBean.StoriesBean storiesBean = mStoriesBeanList.get(position);
        holder.fruitName.setText(storiesBean.getTitle());
        Glide.with(mContext).load(storiesBean.getImages().get(0)).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        LogToastUtils.showShort(mContext,""+mStoriesBeanList.size());
        if (mStoriesBeanList.size() != 0){
            return mStoriesBeanList.size();
        }else {
            return 0;
        }
    }
}
