package com.whpu.market.service.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.service.business.entity.Bill;
import com.whpu.market.service.business.entity.vo.BillQueryVo;
import com.whpu.market.service.business.mapper.BillMapper;
import com.whpu.market.service.business.service.BillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

    @Override
    public boolean checkAndSave(Bill bill) {
        if (
                StringUtils.isEmpty(bill.getProductName())
                || StringUtils.isEmpty(bill.getProductUnit())
                || StringUtils.isEmpty(bill.getProductCount())
                || StringUtils.isEmpty(bill.getTotalPrice())
                || StringUtils.isEmpty(bill.getSupplierId())

        ){
            return false;
        }

        return this.save(bill);
    }

    @Override
    public Bill getFullById(String id) {
        return baseMapper.getFullById(id);
    }

    @Override
    public IPage<Bill> selectPage(Page<Bill> pageParam, BillQueryVo billQueryVo) {

        //排序，先查未付款，再查最新的
        QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("is_payment")
                    .orderByDesc("id");

        queryWrapper.eq("a.is_deleted", 0);

        if (billQueryVo == null){
            return baseMapper.mySelectPage(pageParam, queryWrapper);
        }

        String productName = billQueryVo.getProductName();  //商品名称
        String supplierName = billQueryVo.getSupplierName();    //供应商名称
        Integer isPayment = billQueryVo.getIsPayment();     //是否支付

        if (!StringUtils.isEmpty(productName)){
            queryWrapper.like("product_name", productName);
        }

        if (!StringUtils.isEmpty(supplierName)){
            queryWrapper.like("supplier_name", supplierName);
        }

        if (isPayment != null){
            queryWrapper.eq("is_payment", isPayment);
        }

        return baseMapper.mySelectPage(pageParam, queryWrapper);
    }


}
