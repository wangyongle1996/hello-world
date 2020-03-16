package com.sizu.qrcode.config;


import com.sizu.utils.PropertiesUtil;

public class AliQrPayConfig {

    public final static String RESOURCES = "config/alipay";
    public static String url = PropertiesUtil.getValue(RESOURCES,"alipay.url");

    public static String appid =  PropertiesUtil.getValue(RESOURCES,"alipay.appid");

    public static  String privateKey = PropertiesUtil.getValue(RESOURCES,"alipay.privateKey");

    public static String appCertPath = PropertiesUtil.getValue(RESOURCES,"alipay.appCertPath");

    public static String alipayCertPath = PropertiesUtil.getValue(RESOURCES,"alipay.alipayCertPath");

    public static String alipayRootCertPath = PropertiesUtil.getValue(RESOURCES,"alipay.alipayRootCertPath");

    public static  String callBackUrl = PropertiesUtil.getValue(RESOURCES,"alipay.callBackUrl");


}
