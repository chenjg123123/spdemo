package spring.review.demo.sys.entity;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2023-11-06
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type = IdType.AUTO)
    private int id;

    /**
     * 用户名字
     */
    @TableField("name")
    private String uname;

    /**
     * 用户性别1男0女
     */
    @TableField("sex")
    private char usex;

    /**
     * 用户手机号
     */
    @TableField("userphone")
    private String uphone;

    /**
     * 用户密码
     */
    @TableField("password")
    private String upassword;

    private int companyId;

    private int userPower;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 确认密码
     * 注册成功后设置为0判断用户是否有用户名 没有用户名必须填写才可以进入主界面
     */
    @TableField(exist = false)
    private String reupassword;
    /**
     * 更新时间
     */
    private String  avatar;
    @TableField(exist = false)
    private File file;

    private String  profile;

    private LocalDateTime updateTime;


}
