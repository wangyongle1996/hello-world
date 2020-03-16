package com.sizu.jxcpay.controller;


import com.alipay.api.internal.util.AlipaySignature;
import com.sizu.jxcpay.config.PayConfig;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alibaba/qrcode/pay")
@Slf4j
public class AlibabaPayController {

    @Autowired
    PayConfig payConfig;

    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
       boolean a = false;
        log.info("支付宝扫码支付回调开始:..................");
        log.info("通知时间:{}",request.getParameter("notify_time"));
        log.info("通知类型:{}",request.getParameter("notify_type"));
        log.info("通知校验ID:{}",request.getParameter("notify_id"));
        log.info("签名类型:{}",request.getParameter("sign_type"));
        log.info("签名:{}",request.getParameter("sign"));
        log.info("支付宝交易号:{}",request.getParameter("trade_no"));
        log.info("开发者的app_id:{}",request.getParameter("app_id"));
        log.info("商户订单号:{}",request.getParameter("out_trade_no"));
        log.info("商户业务号:{}",request.getParameter("out_biz_no"));
        log.info("买家支付宝用户号:{}",request.getParameter("buyer_id"));
        log.info("买家支付宝账号:{}",request.getParameter("buyer_logon_id"));
        log.info("卖家支付宝用户号:{}",request.getParameter("seller_id"));
        log.info("卖家支付宝账号:{}",request.getParameter("seller_email"));
        log.info("交易状态:{}",request.getParameter("trade_status"));
        log.info("订单金额:{}",request.getParameter("total_amount"));
        log.info("实收金额:{}",request.getParameter("receipt_amount"));
        log.info("开票金额:{}",request.getParameter("invoice_amount"));
        log.info("付款金额:{}",request.getParameter("buyer_pay_amount"));
        log.info("集分宝金额:{}",request.getParameter("point_amount"));
        log.info("总退款金额:{}",request.getParameter("refund_fee"));
        log.info("实际退款金额:{}",request.getParameter("send_back_fee"));
        log.info("订单标题:{}",request.getParameter("subject"));
        log.info("通知时间:{}",request.getParameter("notify_time"));
        log.info("商品描述:{}",request.getParameter("body"));
        log.info("交易创建时间:{}",request.getParameter("gmt_create"));
        log.info("交易付款时间:{}",request.getParameter("gmt_payment"));
        log.info("交易退款时间:{}",request.getParameter("gmt_refund"));
        log.info("交易结束时间:{}",request.getParameter("gmt_close"));
        log.info("支付金额信息:{}",request.getParameter("fund_bill_list"));

        if (a){
            return;
        }
        Map<String,String> params = new HashMap<>();
        params.put("notify_time",request.getParameter("notify_time"));
        params.put("notify_type",request.getParameter("notify_type"));
        params.put("notify_id",request.getParameter("notify_id"));
        params.put("sign_type",request.getParameter("sign_type"));
        params.put("sign",request.getParameter("sign"));
        params.put("trade_no",request.getParameter("trade_no"));
        params.put("app_id",request.getParameter("app_id"));
        params.put("out_trade_no",request.getParameter("out_trade_no"));
        params.put("buyer_id",request.getParameter("buyer_id"));
        params.put("buyer_logon_id",request.getParameter("buyer_logon_id"));
        params.put("seller_id",request.getParameter("seller_id"));
        params.put("seller_email",request.getParameter("seller_email"));
        params.put("trade_status",request.getParameter("trade_status"));
        params.put("total_amount",request.getParameter("total_amount"));
        params.put("receipt_amount",request.getParameter("receipt_amount"));
        params.put("invoice_amount",request.getParameter("invoice_amount"));
        params.put("buyer_pay_amount",request.getParameter("buyer_pay_amount"));
        params.put("point_amount",request.getParameter("point_amount"));
        params.put("subject",request.getParameter("subject"));
        params.put("gmt_create",request.getParameter("gmt_create"));
        params.put("gmt_payment",request.getParameter("gmt_payment"));
        params.put("fund_bill_list",request.getParameter("fund_bill_list"));
        try {

            //校验阶段
            //1  数字签名校验 安全  作用是此次请求是不是支付宝的请求,请求参数有没有被篡改
            /**
             @param params 参数列表(包括待验签参数和签名值sign) key-参数名称 value-参数值
             @param publicKey 验签公钥
             @param charset 验签字符集
             **/
            if (Security.getProvider("BC") == null){
                Security.addProvider(new BouncyCastleProvider());
            }
            boolean result = AlipaySignature.rsaCertCheckV1(params, payConfig.getAlipayCertPath(), "utf-8");
            if (!result){
                log.info("验签失败.......");
                return;
            }
            //2  判断订单号是否存在  订单号如果不存在 打印日志  return
            //3  判断订单状态是不是未支付或者部分支付  如果不是这两种状态 打印日志 return
            //4  支付宝返回的金额和数据库中的金额是否一致 如果不一致 打印日志  return
            //校验完成  处理业务逻辑
            //修改订单状态 由未支付变成已支付  给用户增加积分\发放优惠价\通知仓库进行发货\增加会员等级
        }catch (Exception ex){
            ex.printStackTrace();
            log.info("支付宝扫码支付回调出现异常");
            return;
        }
        response.getWriter().write("success");
        log.info("支付宝扫码支付回调结束:..................");

    }
}
