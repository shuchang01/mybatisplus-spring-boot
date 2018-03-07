package com.baomidou.springboot.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
@Data
//@Accessors(chain = true)
//@TableName("t_feedback")
public class FeedbackVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer msgId;
    private Integer parentId;
    private Integer userId;
    private String userName;
    private String userEmail;
    private String msgTitle;
    private Integer msgType;
    private Integer msgStatus;
    private String msgContent;
    private Integer msgTime;
    private String messageImg;
    private Integer orderId;
    private Integer msgArea;
    /** FeedbackVO主键id集合 */
    private List<Long> ids = new ArrayList<>();
}
