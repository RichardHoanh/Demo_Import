<template>

  <form @submit.prevent="submitForm">
    <input type="file" ref="fileInput" accept=".xlsx,.xls,.jpg,.jpeg,.png"/>
    <button type="submit">Upload</button>
  </form>


</template>

<script>
import ImportService from "@/ImportService";

export default {
  name: "UploadExcel",
  methods: {
    UploadExcel() {
      this.$refs["excel-upload-input"].click();
    },

    submitForm() {
      const file = this.$refs.fileInput.files[0];
      // Tạo một đối tượng FormData mới, được sử dụng để đóng gói dữ liệu của form để gửi đến server.
      const formData = new FormData();
      // Thêm một cặp key-value vào đối tượng FormData (key là 'file' value là file)
      formData.append('file', file);
      ImportService.uploadFileSevice(formData)
      this.$refs["fileInput"].value = null;
    }


  }

}
</script>

<style scoped>

</style>

