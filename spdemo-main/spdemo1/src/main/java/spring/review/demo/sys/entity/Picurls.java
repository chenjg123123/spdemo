package spring.review.demo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.istack.Nullable;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2023-12-11
 */
public class Picurls implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
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
    private LocalTime createTime;

    /**
     * 修改时间	
     */
    private LocalTime updateTime;

    /**
     * 发帖公司
     */
    private Integer companiesId;

    /**
     * 设置图片地址
     * @return
     */
    public void SetPic(@Nullable String pic1,@Nullable String pic2,@Nullable String pic3,@Nullable String pic4){
            url1 = pic1;   url2 = pic2 ;url3 = pic3;url4 = pic4;
    }

    /**
     * 设置图片地址参数数组
     * @return
     */
    public void SetPic(ArrayList<String> arrayList){
        if(arrayList.size()>0){
            url1 = arrayList.get(0);
        }
        if(arrayList.size()>1){
            url2 = arrayList.get(1);
        }
        if(arrayList.size()>2){
            url3 = arrayList.get(2);
        }
        if(arrayList.size()>3){
            url4 = arrayList.get(3);
        }
    }
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
        return createTime;
    }

    public void setCreateTimne(LocalTime createTimne) {
        this.createTime = createTimne;
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
            ", createTimne=" + createTime +
            ", updateTime=" + updateTime +
            ", companiesId=" + companiesId +
        "}";
    }
}
