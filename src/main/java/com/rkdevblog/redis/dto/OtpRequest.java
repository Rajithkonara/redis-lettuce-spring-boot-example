package com.rkdevblog.redis.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class OtpRequest implements Serializable {

    private String email;
}
