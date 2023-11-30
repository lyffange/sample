package com.exsample.springboot.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ServiceResult {
    private String msg;
    private String code;
    private Object data;
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
}
