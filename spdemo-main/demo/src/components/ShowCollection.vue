<script setup>
defineProps({
  name: [String],
  location: [String],
  sal: [String]
})
</script>
<template>
  <div class="main">
    <div class="date">
      <h1>{{ name }}</h1>
    </div>
    <div class="title">
      <h3>{{ location }}</h3>
    </div>
    <div class="content">
      <h6>{{ sal }}</h6>
    </div>
  </div>
</template>
<style scoped lang="scss">
.main {
  width: 300px;
  height: 250px;
  margin: 5px 30px;
  border: 3px black solid;
  border-radius: 16px;
  display: flex;
  flex-direction: column;
  .date {
    margin-left: 20px;
  }
  .title {
    margin-left: 50px;
    h3 {
      margin: 0;
    }
  }
  .content {
    margin-left: 60px;
    h6 {
      margin: 10px;
    }
  }
}
</style>
