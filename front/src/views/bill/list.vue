<template>
  <div class="app-container">

      <!--查询表单-->
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="searchObj.productName" placeholder="商品名称"/>
      </el-form-item>
      <el-form-item>
        <el-input v-model="searchObj.supplierName" placeholder="供应商"/>
      </el-form-item>

      <el-form-item>
        <el-select v-model="searchObj.isPayment" clearable placeholder="是否付款">
          <el-option value="0" label="未付款"/>
          <el-option value="1" label="已付款"/>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form-item>
    </el-form>

      <!-- 表格 -->
    <el-table :data="list" border stripe>
      <el-table-column
        label="#"
        width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="productName" label="商品名称" />
      <el-table-column prop="supplierName" label="供应商" />
      <el-table-column prop="totalPrice" label="订单总价" />
      <el-table-column prop="isPayment" label="是否付款" >
        <template slot-scope="scope">
          <el-tag v-if="scope.row.isPayment === 0" type="danger">未付款</el-tag>
          <el-tag v-if="scope.row.isPayment === 1"  type="success" >已付款</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="gmtModified" label="操作时间" />

      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <router-link :to="'/bill/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button
            size="mini"
            type="success"
            v-if="scope.row.isPayment === 0"
            @click="payment(scope.row.id)">付款</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="removeById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 8, 9, 10, 20]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total"
      @current-change="changeCurrentPage"
      @size-change="changePageSize"
    />

  </div>
</template>

<script>
import billApi from '@/api/bill'

export default {
    data() {
    return {
      list: [], // 讲师列表
      total: 0, // 总记录数
      page: 1, // 页码
      limit: 9, // 每页记录数
      searchObj: {} // 查询表单
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
        billApi.pageList(this.page, this.limit, this.searchObj).then(response => {
            this.list = response.data.rows
            this.total = response.data.total
        })
    },
    // 修改当前页
    changeCurrentPage(page) {
        this.page = page
        this.fetchData()
    },

    // 修改页大小
    changePageSize(size) {
        this.limit = size
        this.fetchData()
    },
    searchData() {
        this.page = 1
        this.fetchData()
    },
    // 重置查询条件
    resetData() {
        this.page = 1
        this.searchObj = {}
        this.fetchData()
    },

    payment(id){
        billApi.payment(id).then(response => {
            this.$message({
                message: response.message,
                type: 'success'
            })
            this.fetchData()
        })
    },

    removeById(id) {
        // 询问是否删除
        this.$confirm('此操作将删除该订单, 是否继续?', '提示', {
            confirmButtonText: '删除',
            cancelButtonText: '取消',
            type: 'warning'
        }).then(() => {
            return billApi.removeById(id)
        }).then(response => {
            // 刷新页面
            this.fetchData()
            // 弹出成功提示
            this.$message({
                message: response.message,
                type: 'success'
            })
        }).catch((err) => {
            console.log(err)
            if (err === 'cancel') {
                this.$message({
                type: 'info',
                message: '已取消删除'
                })
            }
        })
    }
  }

}
</script>

<style>

</style>