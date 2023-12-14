package spring.review.demo.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2023-12-11
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer categoryid;

    private String categoryname;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "Category{" +
            "categoryid=" + categoryid +
            ", categoryname=" + categoryname +
        "}";
    }
}
