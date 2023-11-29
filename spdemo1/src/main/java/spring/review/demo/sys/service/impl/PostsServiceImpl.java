package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Posts;
import spring.review.demo.sys.mapper.PostsMapper;
import spring.review.demo.sys.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 动态贴文表 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

}
