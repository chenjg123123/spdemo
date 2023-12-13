package spring.review.demo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import spring.review.demo.sys.entity.Companies;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.mapper.CompaniesMapper;
import spring.review.demo.sys.mapper.UserMapper;
import spring.review.demo.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private CompaniesMapper companiesMapper;
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

    public List<User> getUserByPhone(String uphone){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("userphone", uphone);
        log.info("SQL query:{}",wrapper.getSqlSegment());
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(user -> user.setUpassword(null));
        return userList;
    }

    public List<Companies> getCompaniesByUserId(Integer userId){
        User user=userMapper.selectById(userId);
        return companiesMapper.selectListById(user.getCompanyId());
    }
}
