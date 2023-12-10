package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Picurls;
import spring.review.demo.sys.mapper.PicurlsMapper;
import spring.review.demo.sys.service.IPicurlsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-12-08
 */
@Service
public class PicurlsServiceImpl extends ServiceImpl<PicurlsMapper, Picurls> implements IPicurlsService {

}
