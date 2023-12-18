package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Usercollect;
import spring.review.demo.sys.mapper.UsercollectMapper;
import spring.review.demo.sys.service.IUsercollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务收藏表 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-12-18
 */
@Service
public class UsercollectServiceImpl extends ServiceImpl<UsercollectMapper, Usercollect> implements IUsercollectService {

}
