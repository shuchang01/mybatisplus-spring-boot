package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

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
@TableName("t_feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "msg_id", type = IdType.AUTO)
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


}
