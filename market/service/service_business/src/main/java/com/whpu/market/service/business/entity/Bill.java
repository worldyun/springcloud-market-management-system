package com.whpu.market.service.business.entity;

import java.math.BigDecimal;

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
@TableName("business_bill")
@ApiModel(value="Bill对象", description="")
public class Bill extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品描述")
    private String productDesc;

    @ApiModelProperty(value = "商品单位")
    private String productUnit;

    @ApiModelProperty(value = "商品总数")
    private BigDecimal productCount;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "是否支付（0为未支付，1为已支付）")
    private Integer isPayment;

    @ApiModelProperty(value = "供应商id")
    private String supplierId;

    @ApiModelProperty(value = "供应商名称, 忽略字段")
    @TableField(exist = false)  //表中不存在的字段，设置MP忽略此字段
    private String supplierName;

    @ApiModelProperty(value = "是否删除（0为未删除，1为已删除）")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
