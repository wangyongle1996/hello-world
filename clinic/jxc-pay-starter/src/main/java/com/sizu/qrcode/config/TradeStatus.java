package com.sizu.qrcode.config;


import lombok.Getter;

@Getter
public enum TradeStatus {

    TRADE_SUCCESS("TRADE_SUCCESS","支付成功"),
    TRADE_CLOSED("TRADE_CLOSED","交易关闭"),
    TRADE_FINISHED("TRADE_FINISHED","交易完结"),
    WAIT_BUYER_PAY("WAIT_BUYER_PAY","交易创建");

    private String code;
    private String msg;

     TradeStatus(String code, String msg){
        this.code =code;
        this.msg = msg;
    }




}
