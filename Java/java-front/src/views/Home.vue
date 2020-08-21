<template>
  <div class="home">
    <ServletDemo/>
  </div>
</template>

<script>
// @ is an alias to /src
import ServletDemo from '@/components/ServletDemo.vue'

export default {
  name: 'Home',
  components: {
    ServletDemo
  }
}
</script>
