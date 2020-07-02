package com.whpu.market.service.business.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whpu.market.service.business.entity.Bill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface BillMapper extends BaseMapper<Bill> {

    @Select("SELECT a.*,b.supplier_name FROM business_bill a LEFT JOIN business_supplier b ON a.supplier_id = b.id WHERE a.id=#{id}")
    Bill getFullById( String id);

    @Select("SELECT a.*,b.supplier_name FROM business_bill a LEFT JOIN business_supplier b ON a.supplier_id = b.id ${ew.customSqlSegment}")
    IPage<Bill> mySelectPage(IPage<Bill> page, @Param("ew") QueryWrapper<Bill> queryWrapper);
}
