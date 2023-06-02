<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <upload-excel></upload-excel>
</template>

<script>
import UploadExcel from "@/components/UploadExcel";

export default {
  name: 'App',
  components: {
    UploadExcel

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
