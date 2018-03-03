package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 企业（租户）信息表
 * </p>
 *
 * @author Chris
 * @since 2018-02-03
 */
@Data
//@Accessors(chain = true)
@TableName("t_tenant_info")
public class TenantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "dbid", type = IdType.INPUT)
    private Long dbid;
    /**
     * 租户编码
     */
    private String tenantCode;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 邮箱
     */
    private String tenantEmail;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 联系人电话
     */
    private String contactMobile;
    /**
     * 状态
     */
    private String status;
    /**
     * 企业来源
     */
    private String tenantSource;
    /**
     * 审核状态
     */
    private String auditStatus;
    /**
     * 审核备注
     */
    private String auditRemark;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 创建人名称
     */
    private String createdUserName;
    /**
     * 创建时间
     */
    private Date creationDate;
    /**
     * 更新人
     */
    private Long lastUpdatedBy;
    /**
     * 更新人名称
     */
    private String lastUpdatedUserName;
    /**
     * 更新时间
     */
    private Date lastUpdateDate;
    /**
     * 逻辑状态
     */
    private Integer voidFlag;


}
