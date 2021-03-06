package com.wei.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.wei.entity.vo.UserVo;
import com.wei.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-05-01 11:22:00
 */

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @PostMapping("login")
    public R login(String username, String password) {
        return success(this.userService.login(username, password));
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 布尔
     */
    @PostMapping("regsitered")
    public boolean regsitered(String username, String password) {
        return this.userService.regsitered(username, password);
    }

    /**
     * 通过用户名查询用户信息
     *
     * @param nickname 用户昵称
     * @return 用户信息
     */
    @GetMapping("searchUserByNickname")
    public UserVo searchUserByNickname(String nickname) {
        return userService.searchUserByNickname(nickname);
    }

    /**
     * 通过用户名查询用户信息
     *
     * @param uid 用户名
     * @return 用户信息
     */
    @GetMapping("searchUserInfo")
    public R searchUserInfo(Integer uid) {
        if (uid == null) {
            uid = 1;
        }
        return success(this.userService.searchUserInfo(uid));
    }
}