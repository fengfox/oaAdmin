package com.scal.oa.untils;

import com.scal.oa.VO.ResultVO;

public class ResultVOUntil {
    public static ResultVO success(Object object)
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode("0");
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO error(String code,String message)
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
