package com.wangyongle.clininserver.web;


import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.sizu.qrcode.service.AlibabapayQrCodeService;
import com.wangyongle.clininserver.dto.RecipeDto;
import com.wangyongle.clininserver.service.AlibabaPayService;
import com.wangyongle.clininserver.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/biz/alibaba/pay")
@Slf4j
public class AlibabaPayController {

    @Autowired
    AlibabapayQrCodeService alibabapayQrCodeService;

    @Autowired
    AlibabaPayService alibabaPayService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @RequestMapping("/createPayOrder")
    public ResultEntity createPayOrder(RecipeDto recipeDto) throws AlipayApiException {

        log.info("创建支付宝扫码订单开始订单号为:{}",recipeDto.getOrderNo());
        if(redisTemplate.hasKey(recipeDto.getOrderNo())){
            String qrcode = redisTemplate.opsForValue().get(recipeDto.getOrderNo());
            log.info("根据orderNo:{}到redis 中查询二维码:{}",recipeDto.getOrderNo(),qrcode);
            return ResultEntity.ok("创建支付宝扫码支付订单成功",qrcode);
        }
        log.info("根据orderNo:{}到redis 中查询二维码不存在开始调用支付宝的接口创建预支付订单......");
        Map<String,String> map = new HashMap<>();
        map.put("out_trade_no",recipeDto.getOrderNo());
        map.put("trade_no",recipeDto.getOrderNo());
        map.put("total_amount",recipeDto.getPrice().toString());
        map.put("subject",recipeDto.getOrderNo());
        //商家id
        map.put("store_id","2088102180157670");
        map.put("timeout_express","7200m");
        AlipayTradePrecreateResponse qrCodePayOrder = alibabapayQrCodeService.createQrCodePayOrder(map);
        String qrcode = alibabaPayService.getAlibabaPayQRCode(qrCodePayOrder);
        log.info("创建支付宝扫码订单结束订单号为:{}",recipeDto.getOrderNo());
        return ResultEntity.ok("创建支付宝扫码支付订单成功",qrcode);
    }
}
