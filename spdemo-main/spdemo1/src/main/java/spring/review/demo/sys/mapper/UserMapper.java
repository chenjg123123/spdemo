package spring.review.demo.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spring.review.demo.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectCompanyByUser(@Param("companyId") Integer companyId);

}
