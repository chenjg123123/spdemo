package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Messagelist;
import spring.review.demo.sys.mapper.MessagelistMapper;
import spring.review.demo.sys.service.IMessagelistService;
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
public class MessagelistServiceImpl extends ServiceImpl<MessagelistMapper, Messagelist> implements IMessagelistService {

}
