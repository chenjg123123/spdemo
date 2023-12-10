package spring.review.demo.sys.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * <p>
 *
 * </p>
 *
 * @author abc
 * @since 2023-12-08
 */
@Component
public class Picurls implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer picurlsid;

    private String url1;

    private String url2;

    private String url3;

    private String url4;

    /**
     * 用户标识

     */
    private Integer isUser;

    /**
     * 创建时间
     */
    private LocalTime createTimne;

    /**
     * 修改时间

     */
    private LocalTime updateTime;

    /**
     * 发帖公司
     */
    private Integer companiesId;

    public Integer getPicurlsid() {
        return picurlsid;
    }

    public void setPicurlsid(Integer picurlsid) {
        this.picurlsid = picurlsid;
    }
    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }
    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }
    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }
    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }
    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }
    public LocalTime getCreateTimne() {
        return createTimne;
    }

    public void setCreateTimne(LocalTime createTimne) {
        this.createTimne = createTimne;
    }
    public LocalTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getCompaniesId() {
        return companiesId;
    }

    public void setCompaniesId(Integer companiesId) {
        this.companiesId = companiesId;
    }

    @Override
    public String toString() {
        return "Picurls{" +
            "picurlsid=" + picurlsid +
            ", url1=" + url1 +
            ", url2=" + url2 +
            ", url3=" + url3 +
            ", url4=" + url4 +
            ", isUser=" + isUser +
            ", createTimne=" + createTimne +
            ", updateTime=" + updateTime +
            ", companiesId=" + companiesId +
        "}";
    }
}
