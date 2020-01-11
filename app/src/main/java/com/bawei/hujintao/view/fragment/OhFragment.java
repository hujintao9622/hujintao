package com.bawei.hujintao.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.Main2Contract;
import com.bawei.hujintao.model.bean.Main2Bean;
import com.bawei.hujintao.presenter.Main2Presenter;
import com.bawei.hujintao.view.adapter.MainAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 8:51
 */
public class OhFragment extends BaseFragment<Main2Presenter> implements Main2Contract.IView {

    @BindView(R.id.ddr)
    RecyclerView ddr;

    private int key=0;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layoutId() {
        return R.layout.or;
    }

    @Override
    protected Main2Presenter providePresenter() {
        return new Main2Presenter();
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            key = arguments.getInt("key");
        }
        mPresenter.getHome(key);
    }

    @Override
    public void onSuccess(Main2Bean main2Bean) {
        List<Main2Bean.OrderListBean> orderList = main2Bean.getOrderList();
        MainAdapter mainAdapter = new MainAdapter(orderList);
        ddr.setLayoutManager(new LinearLayoutManager(getContext()));
        ddr.setAdapter(mainAdapter);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
    //传值方法
    public static OhFragment getInstance(int value) {
        OhFragment ohFragment = new OhFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key",value);
        ohFragment.setArguments(bundle);
        return ohFragment;
    }
}
