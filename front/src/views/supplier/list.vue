<template>
  <div class="app-container">

    <!--查询表单-->
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="searchObj.supplierName" placeholder="供应商" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="searchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form-item>
    </el-form>

      <el-table :data="list" border stripe>
      <el-table-column
        label="#"
        width="50"
      >
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="id" label="供应商编号" width="180" />
      <el-table-column prop="supplierName" label="供应商名称" />
      <el-table-column prop="supplierContactName" label="联系人名称" />
      <el-table-column prop="supplierContactPhone" label="联系电话" />
      <el-table-column prop="gmtModified" label="操作时间" />
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <router-link :to="'/supplier/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button
            size="mini"
            type="danger"
            @click="removeById(scope.row.id)"
          >删除</el-button>
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
import supplierApi from '@/api/supplier'

export default {

    data() {
        return {
            list: [],   //供应商列表
            total: 0, // 总记录数
            page: 1, // 页码
            limit: 10, // 每页记录数
            searchObj: {} // 查询表单
        }
    },
    created() {
        this.fetchData()
    },

    methods: {
        fetchData() {
            supplierApi.pageList(this.page, this.limit, this.searchObj).then(response => {
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

        removeById(id) {
          // 询问是否删除
          this.$confirm('此操作将删除该供应商, 是否继续?', '提示', {
            confirmButtonText: '删除',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            return supplierApi.removeById(id)
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