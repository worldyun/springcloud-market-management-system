package com.whpu.market.service.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.business.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whpu.market.service.business.entity.Supplier;
import com.whpu.market.service.business.entity.vo.BillQueryVo;
import com.whpu.market.service.business.entity.vo.SupplierQueryVo;


public interface BillService extends IService<Bill> {

    boolean checkAndSave(Bill bill);

    Bill getFullById(String id);

    IPage<Bill> selectPage(Page<Bill> pageParam, BillQueryVo billQueryVo);
}
