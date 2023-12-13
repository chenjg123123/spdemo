package spring.review.demo.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.review.demo.sys.entity.Companies;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 企业表 Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Mapper
public interface CompaniesMapper extends BaseMapper<Companies> {

    List<Companies> selectListById(int companyId);
}
