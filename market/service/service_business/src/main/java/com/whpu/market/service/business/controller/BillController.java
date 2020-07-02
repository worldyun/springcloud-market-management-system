package com.whpu.market.service.business.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.common.base.result.R;
import com.whpu.market.service.business.entity.Bill;
import com.whpu.market.service.business.entity.Supplier;
import com.whpu.market.service.business.entity.vo.BillQueryVo;
import com.whpu.market.service.business.entity.vo.SupplierQueryVo;
import com.whpu.market.service.business.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"bill"})
@RestController
@RequestMapping("/api/business/bill")
public class BillController {

    @Autowired
    BillService billService;

    @SentinelResource(
            value = "BillController.save",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("新增订单")
    @PostMapping("save")
    public R save(
            @ApiParam("订单对象")
            @RequestBody Bill bill
            ){
        boolean result = billService.checkAndSave(bill);
        if (result){
            return R.ok().message("保存成功");
        }else {
            return R.error().message("非法数据");
        }
    }

    @SentinelResource(
            value = "BillController.remove",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation(value = "根据ID删除订单", notes = "根据ID删除订单，逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R deleteUserByID(
            @ApiParam(value = "订单ID", required = true)
            @PathVariable String id
    ) {
        boolean result = billService.removeById(id);
        if(result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "BillController.update",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("更新订单")
    @PutMapping("update")
    public R updateById(
            @ApiParam("订单对象")
            @RequestBody Bill bill
    ){
        boolean result = billService.updateById(bill);
        if(result){
            return R.ok().message("修改成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "BillController.payment",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("订单支付")
    @GetMapping("payment/{id}")
    public R payment(
            @ApiParam(value = "订单Id", required = true)
            @PathVariable String id
    ){
        Bill bill = billService.getById(id);
        if (bill == null){
            return R.error().message("订单不存在");
        }
        bill.setIsPayment(1);
        boolean result = billService.updateById(bill);
        if(result){
            return R.ok().message("支付成功");
        }else{
            return R.error().message("订单不存在");
        }
    }

    @SentinelResource(
            value = "BillController.get",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("根据id获取供订单信息")
    @GetMapping("get/{id}")
    public R getById(
            @ApiParam(value = "订单ID", required = true)
            @PathVariable String id
    ){
        Bill bill = billService.getFullById(id);
        if(bill != null){
            return R.ok().data("item", bill);
        }else{
            return R.error().message("订单不存在");
        }
    }

    @SentinelResource(
            value = "BillController.listPage",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("订单分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("订单查询对象") BillQueryVo billQueryVo ){

        Page<Bill> pageParam = new Page<>(page, limit);
        IPage<Bill> pageModel = billService.selectPage(pageParam, billQueryVo);
        List<Bill> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }
}

