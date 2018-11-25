package com.rest.recaptcha.aspect;

import com.rest.recaptcha.exception.ForbiddenException;
import com.rest.recaptcha.service.CaptchaValidator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CaptchaAspect {

    @Autowired
    private CaptchaValidator captchaValidator;

    private static final String CAPTCHA_HEADER_NAME = "captcha-response";

    @Around("@annotation(RequiresCaptcha)")
    public Object validateCaptcha(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String captchaResponse = request.getHeader(CAPTCHA_HEADER_NAME);
        boolean isValidCaptcha = captchaValidator.validateCaptcha(captchaResponse);
        if(!isValidCaptcha){
            throw new ForbiddenException("Invalid captcha");
        }
        return joinPoint.proceed();
    }

}
