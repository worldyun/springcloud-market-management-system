<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="商品名称">
        <el-input v-model="bill.productName" />
      </el-form-item>
      <el-form-item label="商品单位">
        <el-input v-model="bill.productUnit" />
      </el-form-item>
      <el-form-item label="商品总数">
        <el-input v-model="bill.productCount" />
      </el-form-item>
      <el-form-item label="订单总价">
        <el-input v-model="bill.totalPrice" />
      </el-form-item>

      <el-form-item label="供应商">
        <el-select v-model="bill.supplierId">
          <el-option v-for="item in supplierList" :key="item.id" :value="item.id" :label="item.supplierName" />
        </el-select>
      </el-form-item>

      <el-form-item label="商品描述">
        <el-input v-model="bill.productDesc" :rows="10" type="textarea"/>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import billApi from '@/api/bill'
import supplierApi from '@/api/supplier'

export default {
    data() {
    return {
      // 订单对象
      bill: {},
      //供应商列表
      supplierList: [],
      saveBtnDisabled: false // 默认按钮可用
    }
  },

  created() {
      this.fetchSupplierList()
      if (this.$route.params.id) {
        this.fetchDataById(this.$route.params.id)
      }
  },

  methods: {
      fetchDataById(id){
        billApi.getById(id).then(response => {
          this.bill = response.data.item
        })
      },

      fetchSupplierList(){
          supplierApi.listAll().then(response => {
              this.supplierList = response.data.items
          })
      },

      saveOrUpdate(){
            this.saveBtnDisabled = true
            if (this.$route.params.id) {
                this.updated()
            } else {
                this.saveData()
            }
      },

      // 数据保存
    saveData() {
      billApi.save(this.bill).then(response => {
        // 弹出成功提示
        this.$message({
          message: response.message,
          type: 'success'
        })
        this.$router.push({ path: '/bill' })
      })
    },

    // 数据更新
    updated() {
      billApi.updateById(this.bill).then(response => {
        // 弹出成功提示
        this.$message({
          message: response.message,
          type: 'success'
        })
        this.$router.push({ path: '/bill' })
      })
    },
  }

}
</script>

<style>

</style>