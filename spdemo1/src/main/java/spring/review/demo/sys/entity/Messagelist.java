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
public class Messagelist implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer messageid;

    private Integer senderid;

    /**
     * T是F不是
     */
    private String iscompany;

    private String content;

    private LocalDateTime createTime;

}
