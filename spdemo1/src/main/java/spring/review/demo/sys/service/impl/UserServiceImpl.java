package spring.review.demo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.mapper.UserMapper;
import spring.review.demo.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;
    /**
     * 获得一个注册对象并返回
     */
    public User insertAndGet(User user){
        int result = userMapper.insert(user);
        if(result>0) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUphone,user.getUphone());
            User one = userService.getOne(queryWrapper);
            return  one;
        }
        else {
            return null;
        }
    }
}
