package spring.review.demo.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2023-12-12
 */
@Getter
@Setter
public class Inform implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer informid;

    private Integer sendid;

    /**
     * F OR T
     */
    private String iscompany;

    private LocalDateTime createTime;

    private String title;

    private String content;

    private Integer userid;

    private String snedername;


}
