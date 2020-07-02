package com.whpu.market.service.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.business.entity.Supplier;
import com.whpu.market.service.business.entity.vo.SupplierQueryVo;
import com.whpu.market.service.business.mapper.SupplierMapper;
import com.whpu.market.service.business.service.SupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Override
    public boolean checkAndSave(Supplier supplier) {
        if (StringUtils.isEmpty(supplier.getSupplierName())
                ||StringUtils.isEmpty(supplier.getSupplierContactName())
                ||StringUtils.isEmpty(supplier.getSupplierContactPhone())
        ){
            return false;
        }
        return this.save(supplier);
    }

    @Override
    public IPage<Supplier> selectPage(Page<Supplier> pageParam, SupplierQueryVo supplierQueryVo) {

        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        if (supplierQueryVo == null) {
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        String supplierName = supplierQueryVo.getSupplierName();
        if (!StringUtils.isEmpty(supplierName)){
            queryWrapper.like("supplier_name", supplierName);
        }

        return baseMapper.selectPage(pageParam,queryWrapper);
    }
}
