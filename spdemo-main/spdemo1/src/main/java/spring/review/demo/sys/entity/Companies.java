package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业表
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "company_id", type = IdType.AUTO)
    private Integer companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 企业规模:1 微小型企业,2 中型企业,3 大型企业
     */
    private Integer companyScale;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 企业描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    private LocalDateTime updateDate;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Integer getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(Integer companyScale) {
        this.companyScale = companyScale;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Companies{" +
            "companyId=" + companyId +
            ", companyName=" + companyName +
            ", companyScale=" + companyScale +
            ", industry=" + industry +
            ", description=" + description +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
        "}";
    }
}
