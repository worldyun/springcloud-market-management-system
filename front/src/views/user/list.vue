<template>
  <div class="app-container">

    <!--查询表单-->
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="searchObj.nickName" placeholder="昵称" />
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
      <el-table-column prop="id" label="用户编号" width="180" />
      <el-table-column prop="nickName" label="昵称" />
      <el-table-column prop="userName" label="用户名" />

      <el-table-column prop="sex" label="性别" width="80">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.sex === 1">男</el-tag>
          <el-tag v-if="scope.row.sex === 2" type="danger">女</el-tag>
          <el-tag v-if="scope.row.sex != 2 && scope.row.sex != 1" type="info">未知</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="birth" label="生日" />
      <el-table-column prop="userType" label="权限" width="150">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.userType === 1">管理员</el-tag>
          <el-tag v-if="scope.row.userType === 2" type="success">经理</el-tag>
          <el-tag v-if="scope.row.userType > 2" type="info">员工</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <router-link :to="'/user/edit/'+scope.row.id">
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
import userApi from '@/api/myuser'

export default {
  data() {
    return {
      list: [], // 用户列表
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
    // 加载数据
    fetchData() {
      userApi.pageList(this.page, this.limit, this.searchObj).then(response => {
        this.list = response.data.rows
        this.total = response.data.total
      })
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

    // 删除
    removeById(id) {
      // 询问是否删除
      this.$confirm('此操作将删除该用户, 是否继续?', '提示', {
        confirmButtonText: '删除',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        return userApi.removeById(id)
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
