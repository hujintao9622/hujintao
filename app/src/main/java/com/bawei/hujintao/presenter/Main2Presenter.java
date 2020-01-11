package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.Main2Contract;
import com.bawei.hujintao.model.Main2Model;
import com.bawei.hujintao.model.bean.Main2Bean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:04
 */
public class Main2Presenter extends BasePresenter<Main2Contract.IView> implements Main2Contract.IPresenter {

    private Main2Model main2Model;

    @Override
    protected void initModel() {
        main2Model = new Main2Model();
    }

    @Override
    public void getHome(int status) {
        main2Model.getHome(status, new Main2Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Main2Bean main2Bean) {
                view.onSuccess(main2Bean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
