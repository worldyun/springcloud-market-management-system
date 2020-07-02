package com.whpu.market.service.business.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.market.common.base.result.R;
import com.whpu.market.service.business.entity.Supplier;
import com.whpu.market.service.business.entity.vo.SupplierQueryVo;
import com.whpu.market.service.business.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"supplier"})
@RestController
@RequestMapping("/api/business/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @SentinelResource(
            value = "SupplierController.listAll",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("所有供应商列表")
    @GetMapping("listAll")
    public R listAll(){
        List<Supplier> list = supplierService.list();
        return R.ok().data("items", list);
    }

    @SentinelResource(
            value = "SupplierController.save",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("新增供应商")
    @PostMapping("save")
    public R save(
            @ApiParam("供应商对象")
            @RequestBody Supplier supplier
            ){
        boolean result = supplierService.checkAndSave(supplier);
        if (result){
            return R.ok().message("保存成功");
        }else {
            return R.error().message("非法数据");
        }
    }

    @SentinelResource(
            value = "SupplierController.remove",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation(value = "根据ID删除供应商", notes = "根据ID删除供应商，逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R deleteUserByID(
            @ApiParam(value = "供应商ID", required = true)
            @PathVariable String id
    ) {
        boolean result = supplierService.removeById(id);
        if(result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "SupplierController.update",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("更新供应商")
    @PutMapping("update")
    public R updateById(
            @ApiParam("供应商对象")
            @RequestBody Supplier supplier
    ){
        boolean result = supplierService.updateById(supplier);
        if(result){
            return R.ok().message("修改成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "SupplierController.get",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("根据id获取供应商信息")
    @GetMapping("get/{id}")
    public R getById(
            @ApiParam(value = "供应商ID", required = true)
            @PathVariable String id
    ){
        Supplier supplier = supplierService.getById(id);
        if(supplier != null){
            return R.ok().data("item", supplier);
        }else{
            return R.error().message("数据不存在");
        }
    }

    @SentinelResource(
            value = "SupplierController.listPage",
            blockHandlerClass = com.whpu.market.service.base.handler.SentinelBlockHandler.class,
            blockHandler = "handlerException")
    @ApiOperation("供应商分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("供应商查询对象") SupplierQueryVo supplierQueryVo){

        Page<Supplier> pageParam = new Page<>(page, limit);
        IPage<Supplier> pageModel = supplierService.selectPage(pageParam, supplierQueryVo);
        List<Supplier> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

}

