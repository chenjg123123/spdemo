package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Society;
import spring.review.demo.sys.mapper.SocietyMapper;
import spring.review.demo.sys.service.ISocietyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-12-05
 */
@Service
public class SocietyServiceImpl extends ServiceImpl<SocietyMapper, Society> implements ISocietyService {

}
