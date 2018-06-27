package com.scal.oa.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    private String message;
    private String code;
    private  T data;
}
