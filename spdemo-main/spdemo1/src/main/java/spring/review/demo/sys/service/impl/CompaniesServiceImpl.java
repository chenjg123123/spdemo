package spring.review.demo.sys.service.impl;

import spring.review.demo.sys.entity.Companies;
import spring.review.demo.sys.mapper.CompaniesMapper;
import spring.review.demo.sys.service.ICompaniesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业表 服务实现类
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Service
public class CompaniesServiceImpl extends ServiceImpl<CompaniesMapper, Companies> implements ICompaniesService {

}
