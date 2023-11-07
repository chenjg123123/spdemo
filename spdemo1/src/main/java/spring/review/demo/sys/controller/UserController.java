package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import spring.review.demo.sys.common.R;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.service.IUserService;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * author:abc
     * 登录注册接口
     */
    @PostMapping("/register")
    public R<User> registerUser(HttpServletRequest request, @RequestBody User user) {
        //mp通过前端数据查询是否用户已被注册
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUphone, user.getUphone());
        //获得回传对象
        User one = userService.getOne(queryWrapper);
        //获取时间数据
        LocalDateTime now = LocalDateTime.now();
        if (one == null) {
            //符合没有相同手机号条件 进行注册
            //获取时间戳
            user.setCreateTime(now);
            user.setUpdateTime(now);
            //获取对象密码进行加密 （以修改为数据库中触发器加密)
            //user.setUpassword(DigestUtils.md5DigestAsHex(user.getUpassword().getBytes()));
            User user1 = userService.insertAndGet(user);
            if (user1 == null)
                return R.error("注册失败");
            //给网站设定cookie保存登录 保存token 登陆中使用
            request.getSession().setAttribute("token",user1.getUtoken());
            return R.success(user1);
        }
        return R.error("手机号已使用");
    }
    @PostMapping("/login")
    public R<User> loginUser(HttpServletRequest request,@RequestBody User user){
        LambdaQueryWrapper<User>  queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUphone,user.getUphone());
        User one = userService.getOne(queryWrapper);
        //获取当前密码的MOD5加密后是否和数据库中的相同
        String password = user.getUpassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        boolean equals = password.equals(one.getUpassword());
        System.out.println(equals);
        if(equals){
            return R.success(one);
        }
        return R.error("手机号或密码错误");
    }
}
