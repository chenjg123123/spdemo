package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Orderdetail;
import spring.review.demo.sys.mapper.OrderdetailMapper;
import spring.review.demo.sys.service.IOrderdetailService;
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
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailMapper, Orderdetail> implements IOrderdetailService {

}
