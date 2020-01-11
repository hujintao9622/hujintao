package com.bawei.hujintao.base;

/**
 * 功能:  presenter基类
 * 作者:  胡锦涛
 * 时间:  2020/1/10 0010 上午 11:57
 */
public abstract class BasePresenter<V>{
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
