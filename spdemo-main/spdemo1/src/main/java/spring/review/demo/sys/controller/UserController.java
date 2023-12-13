package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.common.Token;
import spring.review.demo.sys.entity.Companies;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.service.IUserService;
import spring.review.demo.sys.service.impl.UserServiceImpl;
import spring.review.demo.sys.utils.JwtUtils;
import spring.review.demo.sys.utils.RedisUtils;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private UserServiceImpl userServiceimpl;
    /**
     * author:abc
     * 登录注册接口
     */
    @PostMapping("/register")
    public Result<User> registerUser(HttpServletRequest request, @RequestBody User user) {
        //mp通过前端数据查询是否用户已被注册
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUphone, user.getUphone());
        //获得回传对象
        User one = userService.getOne(queryWrapper);
        if (one == null) {
            //符合没有相同手机号条件 进行注册
            //获取时间戳
            //获取时间数据
            LocalDateTime now = LocalDateTime.now();
            user.setCreateTime(now);
            user.setUpdateTime(now);
            user.setCompanyId(1);
            //获取对象密码进行加密 （以修改为数据库中触发器加密)
            //user.setUpassword(DigestUtils.md5DigestAsHex(user.getUpassword().getBytes()));
            User user1 = userService.insertAndGet(user);
            if (user1 == null)
                return Result.error("注册失败");

            return Result.success("user",user1,"注册成功");
        }
        return Result.error("手机号已使用");
    }

    /**
     *
     * @param request
     * @param user
     * author: abc
     * 登录接口
     * @return
     */
    @PostMapping("/login")
    public Result loginUser(HttpServletRequest request, @RequestBody User user){
        LambdaQueryWrapper<User>  queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUphone,user.getUphone());
        User one = userService.getOne(queryWrapper);
        //获取当前密码的MOD5加密后是否和数据库中的相同
        String password = user.getUpassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        boolean equals = password.equals(one.getUpassword());
        if(equals){
            // 构造JWT令牌中的Claims
            Map<String,Object> claims=new HashMap<>();
            claims.put("id", user.getId());
            claims.put("name", user.getUname());
            claims.put("phone", user.getUphone());

            // 生成JWT令牌
            String jwt = JwtUtils.generateJwt(claims);
            Token token = new Token(jwt);
            //登录成功,返回JWT令牌
            return Result.success("token",token,"登陆成功");
        }
        return Result.error("手机号或密码错误");
    }

    //根据手机号码查询个人全部信息
    @GetMapping("/personal")
    public Result<List<User>> getUserByUphone(@RequestBody Map<String,String> requestBody){
        String uphone=requestBody.get("uphone");
        List<User> userList=userServiceimpl.getUserByPhone(uphone);
        return Result.success("userList", userList, "查询成功");
    }

    //根据userId的外键companyId,查询公司信息
    @GetMapping("/companies")
    public Result<List<Companies>> getCompaniesByUserId(@RequestBody Map<String, Integer> requestBody) {
        Integer userId = requestBody.get("userId");
        List<Companies> companiesList = userServiceimpl.getCompaniesByUserId(userId);

        if (companiesList != null && !companiesList.isEmpty()) {
            return Result.success("companiesList", companiesList, "查询成功");
        } else {
            return Result.error("未找到对应企业");
        }
    }
}
