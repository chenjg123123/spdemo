package spring.review.demo.sys.controller;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.common.Token;
import spring.review.demo.sys.entity.Companies;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.service.ICompaniesService;
import spring.review.demo.sys.service.IUserService;
import spring.review.demo.sys.utils.AliOSSUtils;
import spring.review.demo.sys.utils.JwtUtils;
import spring.review.demo.sys.utils.RedisUtils;
import spring.review.demo.sys.utils.upload;

import java.io.File;
import java.io.IOException;
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
    private ICompaniesService companiesService;

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
        if(one==null) return Result.error("用户不存在");
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
            one.setUpassword(" ");
            return Result.success("token",token,"登陆成功").add("username",one);
        }
        return Result.error("手机号或密码错误");
    }
    @GetMapping("/userByid")
    public Result getUserById (@RequestParam Integer userId){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,userId);
        User one = userService.getOne(userLambdaQueryWrapper);
        LambdaQueryWrapper<Companies> companiesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        companiesLambdaQueryWrapper.eq(Companies::getCompanyId,one.getCompanyId());
        Companies one1 = companiesService.getOne(companiesLambdaQueryWrapper);
        one.setUpassword(" ");
        return Result.success("Info",one).add("company",one1);
    }
    @PutMapping("/update")
    public Result update(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        System.out.println("12321321421321"+files.size());
        String usex = params.getParameter("usex");
        String uname = params.getParameter("uname");
        String uphone = params.getParameter("uphone");
        String profile = params.getParameter("profile");
        String id = params.getParameter("id");
        User user = new User();
        user.setUsex(usex.charAt(0));
        user.setUname(uname);
        user.setUphone(uphone);
        user.setProfile(profile);
        user.setId(Integer.parseInt(id));
        if(files.size()>0) {
            AliOSSUtils aliOSSUtils = new AliOSSUtils();
            String avatar = aliOSSUtils.upload(files.get(0));
            user.setAvatar(avatar);
        }
        LambdaQueryWrapper<User>userLambdaQueryWrapper= new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,user.getId());
        userService.updateById(user);
        User one = userService.getOne(userLambdaQueryWrapper);
        return Result.success("one",one,"修改成功");
    }
    @GetMapping("/upload")
    public Result upload(HttpServletRequest request){

        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("photoFile");
        String name= params.getParameter("data");
        System.out.println(files);
        return  Result.success("success",null,"更新成功");
    }
}
