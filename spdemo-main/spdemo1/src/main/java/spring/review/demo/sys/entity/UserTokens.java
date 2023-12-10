package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 存储令牌
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@TableName("user_tokens")
public class UserTokens implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 外键,用户名
     */
    private Integer userId;

    /**
     * 生成的令牌值
     */
    private String tokenValue;

    /**
     * 令牌的过期时间
     */
    private LocalDateTime expirationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "UserTokens{" +
            "id=" + id +
            ", userId=" + userId +
            ", tokenValue=" + tokenValue +
            ", expirationTime=" + expirationTime +
        "}";
    }
}
