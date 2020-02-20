package com.rkdevblog.redis.dto;

import lombok.Getter;

@Getter
public class OtpValidateRequest {

    private String key;
    private String otp;

}
