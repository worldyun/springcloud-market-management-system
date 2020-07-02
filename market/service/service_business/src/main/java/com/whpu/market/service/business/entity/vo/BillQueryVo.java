package com.whpu.market.service.business.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("Bill查询对象")
@Data
public class BillQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名")
    private String productName;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty( value = "是否付款, 0为未付款，1为已付款")
    private Integer isPayment;
}
