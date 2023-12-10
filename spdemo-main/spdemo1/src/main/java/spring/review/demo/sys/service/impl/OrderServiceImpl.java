package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Order;
import spring.review.demo.sys.mapper.OrderMapper;
import spring.review.demo.sys.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
