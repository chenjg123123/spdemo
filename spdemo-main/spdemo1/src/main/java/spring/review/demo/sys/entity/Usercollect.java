package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 业务收藏表
 * </p>
 *
 * @author abc
 * @since 2023-12-18
 */
@Getter
@Setter
public class Usercollect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务主键
     */
    @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;

    /**
     * 用户名
     */
    private Integer userId;

    /**
     * 业务名
     */
    private Integer communityId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
