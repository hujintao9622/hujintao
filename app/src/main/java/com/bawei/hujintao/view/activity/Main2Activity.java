package com.bawei.hujintao.view.activity;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseAcitivity;
import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.view.fragment.OhFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseAcitivity {
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        OhFragment o1 = OhFragment.getInstance(0);
        OhFragment o2 = OhFragment.getInstance(1);
        OhFragment o3 = OhFragment.getInstance(2);
        OhFragment o4 = OhFragment.getInstance(3);
        OhFragment o5 = OhFragment.getInstance(9);
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
        rg.check(rg.getChildAt(0).getId());
        vp.setCurrentItem(0);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }


}
