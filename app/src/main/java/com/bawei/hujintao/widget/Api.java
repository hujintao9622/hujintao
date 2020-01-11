package com.bawei.hujintao.widget;

import com.bawei.hujintao.model.bean.Main2Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/11 0011 上午 9:31
 */
public interface Api {
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<Main2Bean> ma(@Header("userId") String uid, @Header("sessionId") String sid, @Query("status")int s,@Query("page")int page,@Query("count")int count);
}
