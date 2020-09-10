<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 500px">
      <el-table-column
        prop="name"
        label="NAME"
        width="180">
      </el-table-column>
      <el-table-column
        prop="city"
        label="CITY">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="handleClick(scope.row)">编辑</el-button>
          <el-button type="text" size="small" @click="handleClick(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button @click="save">Save</el-button>
    <el-button @click="save">Add</el-button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ServletDemo',
  data: () => {
    return {
      tableData: [
        {
          name: '',
          city: ''
        }
      ]
    }
  },
  created () {
    this.getDataFromMysql()
  },
  methods: {
    handleClick (row) {
      console.log(row)
    },
    save () {
      console.log('save')
    },
    getDataFromMysql: function () {
      const _this = this
      axios.get('http://localhost/classes/demo1')
        .then(response => {
          _this.tableData = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    }
    // getDataFromPostman: function () {
    //   const _this = this
    //   axios.post('https://552d84f6-e391-438e-9b57-493734fc4bf3.mock.pstmn.io/customers/city')
    //     .then(response => {
    //       _this.tableData = response.data
    //     })
    //     .catch(function (error) {
    //       console.log(error)
    //     })
    // },
  }
}
</script>

<style scoped lang="scss">
</style>
