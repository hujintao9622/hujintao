package com.bawei.hujintao.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.model.bean.Main2Bean;
import com.bawei.hujintao.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:11
 */
public class Main2Adapter extends RecyclerView.Adapter<Main2Adapter.MyViewHolder> {


    private int k;
    private List<Main2Bean.OrderListBean.DetailListBean> list;

    public Main2Adapter(int orderStatus, List<Main2Bean.OrderListBean.DetailListBean> detailList) {

        k = orderStatus;
        list = detailList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemb, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Main2Bean.OrderListBean.DetailListBean detailListBean = list.get(position);
        holder.itName.setText(detailListBean.getCommodityName());
        holder.itPrice.setText(detailListBean.getCommodityPrice()+"");
        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split(",");
        NetUtil.getInstance().getPhoto(split[0],holder.itImg);
        switch (k){
            case 1:
                holder.itBt.setVisibility(View.VISIBLE);
                holder.itBt.setText("待付款");
                break;
            case 2:
                holder.itBt.setVisibility(View.VISIBLE);
                holder.itBt.setText("待收货");
                break;
            case 3:
                holder.itBt.setVisibility(View.VISIBLE);
                holder.itBt.setText("待评价");
                break;
            case 9:
                holder.itBt.setVisibility(View.GONE);
                holder.itBt.setText("待付款");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.it_img)
        ImageView itImg;
        @BindView(R.id.it_name)
        TextView itName;
        @BindView(R.id.it_price)
        TextView itPrice;
        @BindView(R.id.it_bt)
        Button itBt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
