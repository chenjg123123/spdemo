package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 业务需求表
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@TableName("business_demands")
public class BusinessDemands implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务需求表ID
     */
    @TableId(value = "demand_id", type = IdType.AUTO)
    private Integer demandId;

    /**
     * 外键，关联到企业表的主键,创建改业务需求的用户所属公司id
     */
    private Integer companyId;

    /**
     * 哪个用户发布的
     */
    private Integer userId;

    /**
     * 需求标题
     */
    private String title;

    /**
     * 需求描述
     */
    private String description;

    /**
     * 需求是否已被接取:1,未被接取 , 0,已被接取
     */
    private Integer isTaken;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(Integer isTaken) {
        this.isTaken = isTaken;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BusinessDemands{" +
            "demandId=" + demandId +
            ", companyId=" + companyId +
            ", userId=" + userId +
            ", title=" + title +
            ", description=" + description +
            ", isTaken=" + isTaken +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
