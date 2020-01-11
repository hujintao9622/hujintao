package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.Main2Bean;
import com.bawei.hujintao.view.activity.Main2Activity;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:00
 */
public interface Main2Contract {
    interface IView{
        void onSuccess(Main2Bean main2Bean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getHome(int status);
    }
    interface IModel{
        void getHome(int status,IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(Main2Bean main2Bean);
            void onFailure(Throwable throwable);
        }
    }
}
