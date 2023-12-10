package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.BusinessDemands;
import spring.review.demo.sys.mapper.BusinessDemandsMapper;
import spring.review.demo.sys.service.IBusinessDemandsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务需求表 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Service
public class BusinessDemandsServiceImpl extends ServiceImpl<BusinessDemandsMapper, BusinessDemands> implements IBusinessDemandsService {

}
