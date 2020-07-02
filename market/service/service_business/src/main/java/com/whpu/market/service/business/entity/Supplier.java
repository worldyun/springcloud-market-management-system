package com.whpu.market.service.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.whpu.market.service.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("business_supplier")
@ApiModel(value="Supplier对象", description="")
public class Supplier extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "供应商描述")
    private String supplierDesc;

    @ApiModelProperty(value = "联系人名称")
    private String supplierContactName;

    @ApiModelProperty(value = "联系电话")
    private String supplierContactPhone;

    @ApiModelProperty(value = " 是否删除（0为未删，1为删除）")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(value = "联系地址")
    private String supplierContactAddress;


}
