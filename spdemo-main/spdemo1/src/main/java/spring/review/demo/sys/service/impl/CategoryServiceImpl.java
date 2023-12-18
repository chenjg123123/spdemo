package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Category;
import spring.review.demo.sys.mapper.CategoryMapper;
import spring.review.demo.sys.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-12-11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
