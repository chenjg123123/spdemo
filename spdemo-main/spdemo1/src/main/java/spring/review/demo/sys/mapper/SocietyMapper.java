package spring.review.demo.sys.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import spring.review.demo.sys.entity.Society;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-12-05
 */
@Mapper
public interface SocietyMapper extends BaseMapper<Society> {

}
