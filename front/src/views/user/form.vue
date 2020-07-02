<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="用户名">
        <el-input v-model="user.userName" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="user.nickName" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.passWord" />
      </el-form-item>
      <el-form-item label="生日">
        <el-date-picker v-model="user.birth" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="user.sex">
          <el-option :value="1" label="男" />
          <el-option :value="2" label="女" />
        </el-select>
      </el-form-item>

      <el-form-item label="权限">
        <el-select v-model="user.userType">
          <el-option :value="1" label="管理员" />
          <el-option :value="2" label="经理" />
          <el-option :value="3" label="员工" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import userApi from '@/api/myuser'

export default {
  data() {
    return {
      // 用户对象
      user: {},
      saveBtnDisabled: false // 默认按钮可用
    }
  },
  created() {
    if (this.$route.params.id) {
      this.fetchDataById(this.$route.params.id)
    }
  },
  methods: {
    // 根据id查询数据
    fetchDataById(id) {
      userApi.getById(id).then(response => {
        this.user = response.data.item
      })
    },

    saveOrUpdate() {
      if (this.$route.params.id) {
        this.updated()
      } else {
        this.saveData()
      }
    },

    saveData() {
      userApi.save(this.user).then(response => {
        this.$message({
          message: response.message,
          type: 'success'
        })
        this.$router.push({ path: '/user' })
      })
    },

    updated() {
      userApi.updateById(this.user).then(response => {
        this.$message({
          message: response.message,
          type: 'success'
        })
        this.$router.push({ path: '/user' })
      })
    }
  }
}
</script>

<style>
</style>
