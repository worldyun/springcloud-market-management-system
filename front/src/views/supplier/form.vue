<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="供应商名称">
        <el-input v-model="supplier.supplierName" />
      </el-form-item>
      <el-form-item label="联系人名称">
        <el-input v-model="supplier.supplierContactName" />
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="supplier.supplierContactPhone" />
      </el-form-item>
      <el-form-item label="联系地址">
        <el-input v-model="supplier.supplierContactAddress" />
      </el-form-item>
      <el-form-item label="供应商描述">
        <el-input type="textarea" v-model="supplier.supplierDesc" />
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import supplierApi from '@/api/supplier'
export default {

    data() {
        return {
            // 供应商对象
            supplier: {},
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
        supplierApi.getById(id).then(response => {
          this.supplier = response.data.item
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
        supplierApi.save(this.supplier).then(response => {
          this.$message({
            message: response.message,
            type: 'success'
          })
          this.$router.push({ path: '/supplier' })
        })
      },

      updated() {
        supplierApi.updateById(this.supplier).then(response => {
          this.$message({
            message: response.message,
            type: 'success'
          })
          this.$router.push({ path: '/supplier' })
        })
      }
    }
    
}
</script>

<style>

</style>