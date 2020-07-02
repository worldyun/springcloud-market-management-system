package com.whpu.market.service.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.business.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whpu.market.service.business.entity.vo.SupplierQueryVo;


public interface SupplierService extends IService<Supplier> {

    boolean checkAndSave(Supplier supplier);

    IPage<Supplier> selectPage(Page<Supplier> pageParam, SupplierQueryVo supplierQueryVo);
}
