package com.scal.oa.Contorller;

import com.scal.oa.Service.UserService;
import com.scal.oa.VO.ResultVO;
import com.scal.oa.untils.ResultVOUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResultVO login(@PathParam("userNmae")String userName, @PathParam("pwd")String pwd)
    {

        boolean result=userService.login(userName,pwd);
        return ResultVOUntil.success(result);



    }
}
