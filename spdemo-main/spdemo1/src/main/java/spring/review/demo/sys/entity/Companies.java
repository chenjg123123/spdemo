package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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



    //头像
    private String companyAvatar;
    //地址
    private String companyAddress;
    //业务
    private String companyBusiness;
    //营业时间
    @TableField("company_work_time")
    private String companyWorkTime;
}