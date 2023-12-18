package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 私信与业务消息表
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 私信与业务消息表id
     */
    @TableId(value = "massage_id", type = IdType.AUTO)
    private Integer massageId;

    /**
     * 外键,所属发送用户企业
     */
    private Integer senderCompanyId;

    /**
     * 外键,所属发送用户
     */
    private Integer senderId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息创建时间
     */
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    public String senderName;

    public String receiverName;

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 所属接收方用户id
     */
    private Integer receiverId;

    /**
     * 所属接收方用户企业id
     */
    private Integer receiverCompanyId;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getMassageId() {
        return massageId;
    }

    public void setMassageId(Integer massageId) {
        this.massageId = massageId;
    }
    public Integer getSenderCompanyId() {
        return senderCompanyId;
    }

    public void setSenderCompanyId(Integer senderCompanyId) {
        this.senderCompanyId = senderCompanyId;
    }
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
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
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }
    public Integer getReceiverCompanyId() {
        return receiverCompanyId;
    }

    public void setReceiverCompanyId(Integer receiverCompanyId) {
        this.receiverCompanyId = receiverCompanyId;
    }

    @Override
    public String toString() {
        return "Messages{" +
            "massageId=" + massageId +
            ", senderCompanyId=" + senderCompanyId +
            ", senderId=" + senderId +
            ", content=" + content +
            ", createTime=" + createTime +
            ", receiverId=" + receiverId +
            ", receiverCompanyId=" + receiverCompanyId +
        "}";
    }
}
