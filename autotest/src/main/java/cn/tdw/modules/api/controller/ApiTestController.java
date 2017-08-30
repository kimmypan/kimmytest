package cn.tdw.modules.api.controller;


import cn.tdw.common.utils.R;
import cn.tdw.modules.api.annotation.AuthIgnore;
import cn.tdw.modules.api.annotation.LoginUser;
import cn.tdw.modules.api.entity.TokenEntity;
import cn.tdw.modules.api.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

/**
 * API测试接口
 *
 *
 *
 * @date 2017-03-23 15:47
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    /**
     * 获取用户信息
     */
    @GetMapping("userInfo")
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    /**
     * 忽略Token验证测试
     */
    @AuthIgnore
    @GetMapping("notToken")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

    /**
     * 接收JSON数据
     */
    @PostMapping("jsonData")
    public R jsonData(@LoginUser UserEntity user, @RequestBody TokenEntity token){
        return R.ok().put("user", user).put("token", token);
    }
}
