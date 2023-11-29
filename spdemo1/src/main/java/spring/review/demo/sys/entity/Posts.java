package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 动态贴文表
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 动态贴文表id
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    /**
     * 所属用户公司id
     */
    private Integer companiesId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 贴文标题
     */
    private String title;

    /**
     * 贴文内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public Integer getCompaniesId() {
        return companiesId;
    }

    public void setCompaniesId(Integer companiesId) {
        this.companiesId = companiesId;
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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Posts{" +
            "postId=" + postId +
            ", companiesId=" + companiesId +
            ", userId=" + userId +
            ", title=" + title +
            ", content=" + content +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
