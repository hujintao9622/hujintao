package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.Main2Contract;
import com.bawei.hujintao.model.bean.Main2Bean;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:02
 */
public class Main2Model implements Main2Contract.IModel {
    @Override
    public void getHome(int status, IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().ma("13107","157870414138913107",status,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Main2Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Main2Bean main2Bean) {
                        iModelCallback.onSuccess(main2Bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
