package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户token
     */
    private String utoken;

    /**
     * 用户名字
     */
    private String uname;

    /**
     * 用户性别1男0女
     */
    private Integer usex;

    /**
     * 用户手机号
     */
    private String uphone;

    /**
     * 用户密码
     */
    private String upassword;

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
    private LocalDateTime updateTime;

    public String getUtoken() {
        return utoken;
    }

    public void setUtoken(String utoken) {
        this.utoken = utoken;
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }
    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }
    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
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
    public String getreupassword() {
        return reupassword;
    }

    public void setreupassword(String reupassword) {
        this.reupassword = reupassword;
    }
    @Override
    public String toString() {
        return "User{" +
            "utoken=" + utoken +
            ", uname=" + uname +
            ", usex=" + usex +
            ", uphone=" + uphone +
            ", upassword=" + upassword +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
                ", reupassword=" + reupassword +
        "}";
    }
}
