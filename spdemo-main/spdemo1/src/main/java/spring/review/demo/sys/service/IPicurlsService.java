package spring.review.demo.sys.service;

import spring.review.demo.sys.entity.Picurls;
import com.baomidou.mybatisplus.extension.service.IService;
import spring.review.demo.sys.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author abc
 * @since 2023-12-11
 */
public interface IPicurlsService extends IService<Picurls> {
    public Picurls insertAndGet(Picurls picurls);
}
