package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.UserTokens;
import spring.review.demo.sys.mapper.UserTokensMapper;
import spring.review.demo.sys.service.IUserTokensService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存储令牌 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Service
public class UserTokensServiceImpl extends ServiceImpl<UserTokensMapper, UserTokens> implements IUserTokensService {

}
