package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Messages;
import spring.review.demo.sys.mapper.MessagesMapper;
import spring.review.demo.sys.service.IMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 私信与业务消息表 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Service
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements IMessagesService {

}
