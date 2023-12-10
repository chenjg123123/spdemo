package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2023-12-05
 */
public class Society implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帖子ID
     */
    @TableId(value = "SID", type = IdType.AUTO)
    private Integer sid;

    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    @TableField(exist = false)
    private String Username;

    private String content;

    private Long picurlsid;

    private LocalDateTime createTime;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private LocalDateTime updateTime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Long getPicurlsid() {
        return picurlsid;
    }

    public void setPicurlsid(Long picurlsid) {
        this.picurlsid = picurlsid;
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
        return "Society{" +
            "sid=" + sid +
            ", userid=" + userid +
            ", title=" + title +
            ", content=" + content +
            ", picurlsid=" + picurlsid +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
