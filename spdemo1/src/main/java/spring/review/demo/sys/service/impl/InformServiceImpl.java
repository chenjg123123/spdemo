package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Inform;
import spring.review.demo.sys.mapper.InformMapper;
import spring.review.demo.sys.service.IInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-12-12
 */
@Service
public class InformServiceImpl extends ServiceImpl<InformMapper, Inform> implements IInformService {

}
