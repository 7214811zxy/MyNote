<template>
  <div>
    <button @click="clickAxios">Vue</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ServletDemo',
  methods: {
    clickAxios: function () {
      axios.get('http://192.168.2.131:80/demo4', {
        headers: {
          person: 'jupyter'
        }
      })
        .then(response => {
          console.log(response)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped lang="scss">
</style>
