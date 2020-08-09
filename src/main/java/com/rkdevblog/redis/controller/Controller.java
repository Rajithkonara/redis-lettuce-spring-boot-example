package com.rkdevblog.redis.controller;

import com.rkdevblog.redis.dto.OtpRequest;
import com.rkdevblog.redis.dto.OtpValidateRequest;
import com.rkdevblog.redis.repository.CacheRepository;
import com.rkdevblog.redis.util.OtpGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/otp")
public class Controller {

    private final CacheRepository cacheRepository;
    private final OtpGenerator otpGenerator;

    @Autowired
    public Controller(CacheRepository cacheRepository, OtpGenerator otpGenerator) {
        this.cacheRepository = cacheRepository;
        this.otpGenerator = otpGenerator;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> addToCache(@RequestBody OtpRequest key) {
        log.debug("Generating otp for {} ", key.getEmail());
        int value = otpGenerator.generateOtp();
        cacheRepository.put(key.getEmail(), value);
        return ResponseEntity.ok("Otp Generated Successfully Otp : " + value);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> removeFromCache(@RequestBody OtpValidateRequest otpValidateRequest) {
        Optional<String> s = cacheRepository.get(otpValidateRequest.getKey());
        if (s.isPresent() && s.get().equals(otpValidateRequest.getOtp())) {
            log.debug("Found the key in cache {} ", otpValidateRequest.getOtp());
            cacheRepository.remove(otpValidateRequest.getKey());
            return ResponseEntity.ok("Key Removed from cache key:  " + otpValidateRequest.getKey());
        }
        return ResponseEntity.badRequest().body("Invalid Otp");
    }

}
