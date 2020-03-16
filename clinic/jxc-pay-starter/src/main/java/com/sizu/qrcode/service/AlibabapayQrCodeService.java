package com.sizu.qrcode.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.sizu.qrcode.config.AliQrPayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 干活的类
 */
@Service
@Slf4j
public class AlibabapayQrCodeService {



    public AlipayTradePrecreateResponse createQrCodePayOrder(Map<String, String> map) throws AlipayApiException {
        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl(AliQrPayConfig.url);
        //设置应用Id
        certAlipayRequest.setAppId(AliQrPayConfig.appid);
        //设置应用私钥
        certAlipayRequest.setPrivateKey(AliQrPayConfig.privateKey);
        //设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        //设置字符集
        certAlipayRequest.setCharset("utf-8");
        //设置签名类型
        certAlipayRequest.setSignType("RSA2");
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath(AliQrPayConfig.appCertPath);
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(AliQrPayConfig.alipayCertPath);
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(AliQrPayConfig.alipayRootCertPath);
        //构造client
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        //构造API请求
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setNotifyUrl(AliQrPayConfig.callBackUrl);
        request.setBizContent(JSON.toJSONString(map));//订单允许的最晚付款时间
        //发送请求
        AlipayTradePrecreateResponse alipayTradePrecreateResponse = alipayClient.certificateExecute(request);
        log.info("请求支付宝返回的结果为:{}",alipayTradePrecreateResponse.getBody());
        return alipayTradePrecreateResponse;
    }

    public AlipayTradeQueryResponse queryOrder(Map<String, String> map) throws AlipayApiException {
        AlipayClient alipayClient = getAlipayClient();
        //构造API请求
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(JSON.toJSONString(map));//订单允许的最晚付款时间
        //发送请求
        AlipayTradeQueryResponse response = alipayClient.certificateExecute(request);
        log.info("请求支付宝查询接口返回的结果为:{}",response.getBody());
        return response;
    }

    private AlipayClient getAlipayClient() throws AlipayApiException {
        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl(AliQrPayConfig.url);
        //设置应用Id
        certAlipayRequest.setAppId(AliQrPayConfig.appid);
        //设置应用私钥
        certAlipayRequest.setPrivateKey(AliQrPayConfig.privateKey);
        //设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        //设置字符集
        certAlipayRequest.setCharset("utf-8");
        //设置签名类型
        certAlipayRequest.setSignType("RSA2");
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath(AliQrPayConfig.appCertPath);
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(AliQrPayConfig.alipayCertPath);
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(AliQrPayConfig.alipayRootCertPath);
        //构造client
        return new DefaultAlipayClient(certAlipayRequest);
    }
}
