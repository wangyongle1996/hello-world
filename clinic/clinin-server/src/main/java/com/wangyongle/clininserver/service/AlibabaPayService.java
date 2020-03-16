package com.wangyongle.clininserver.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import java.util.Map;

public interface AlibabaPayService {


    String getAlibabaPayQRCode(AlipayTradePrecreateResponse qrCodePayOrder);
}
