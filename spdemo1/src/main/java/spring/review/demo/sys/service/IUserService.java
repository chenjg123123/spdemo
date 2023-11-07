package spring.review.demo.sys.service;

import spring.review.demo.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
public interface IUserService extends IService<User> {
    public User insertAndGet(User user);
}
