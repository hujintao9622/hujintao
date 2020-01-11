package com.bawei.hujintao.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.model.bean.Main2Bean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:11
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private List<Main2Bean.OrderListBean> list;

    public MainAdapter(List<Main2Bean.OrderListBean> orderList) {

        list = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itema, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Main2Bean.OrderListBean orderListBean = list.get(position);
        holder.it1Name.setText(orderListBean.getOrderId());
        holder.it1T.setText(orderListBean.getOrderTime()+"");
        holder.it1Rc.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        int orderStatus = orderListBean.getOrderStatus();
        holder.it1Rc.setAdapter(new Main2Adapter(orderStatus,orderListBean.getDetailList()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.it1_name)
        TextView it1Name;
        @BindView(R.id.it1_rc)
        RecyclerView it1Rc;
        @BindView(R.id.it1_t)
        TextView it1T;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
