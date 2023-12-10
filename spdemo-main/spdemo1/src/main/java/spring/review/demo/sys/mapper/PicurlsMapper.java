package spring.review.demo.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.review.demo.sys.entity.Picurls;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-12-08
 */
@Mapper
public interface PicurlsMapper extends BaseMapper<Picurls> {

}
