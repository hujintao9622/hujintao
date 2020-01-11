package com.bawei.hujintao.model.bean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/10 0010 下午 2:03
 */
public class LoadOrderBean {
    /**
     * orderId : 2020011009313848613107
     * message : 创建订单成功
     * status : 0000
     */

    private String orderId;
    private String message;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
