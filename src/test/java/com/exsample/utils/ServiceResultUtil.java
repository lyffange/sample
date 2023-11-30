package com.exsample.utils;

import com.exsample.springboot.domain.dto.ServiceResult;

public class ServiceResultUtil {
    public static ServiceResult getServiceResult(String code,String msg,Object data){
        ServiceResult result = new ServiceResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
