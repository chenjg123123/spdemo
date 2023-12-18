package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 社区内容
 * </p>
 *
 * @author abc
 * @since 2023-12-15
 */
@Getter
@Setter
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键	
     */
    @TableId(value = "community_id", type = IdType.AUTO)
    private Integer communityId;

    /**
     * 公司外键	
     */
    private Integer companiesId;

    private Integer userId;

    /**
     * 工作名字
     */
    private String workName;

    /**
     * 工作薪资
     */
    private String workRemuneration;

    /**
     * 工作内容
     */
    private String workContent;

    /**
     * 工作地点
     */
    private String workLocations;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 图片地址
     */
    private Integer picurlsid;
}
