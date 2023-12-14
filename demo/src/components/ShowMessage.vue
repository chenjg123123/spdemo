<script setup>
defineProps({
  date: [String],
  title: [String],
  content: [String]
})
const formatDate = (dateString) => {
  const date = new Date(dateString)
  const options = {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit'
  }
  return date.toLocaleDateString('en-US', options)
}
</script>
<template>
  <div class="main">
    <div class="date">
      <h1>{{ formatDate(date) }}</h1>
    </div>
    <div class="title">
      <h3>{{ title }}</h3>
    </div>
    <div class="content">
      <h6>{{ content }}</h6>
    </div>
    <div class="pic">
      <img
        src="https://tse2-mm.cn.bing.net/th/id/OIP-C.eSpAhJ8i75zSrfa1cacOQgHaHa?w=194&h=194&c=7&r=0&o=5&dpr=2&pid=1.7"
      />
    </div>
  </div>
</template>
<style scoped lang="scss">
.main {
  width: 98%;
  height: 250px;
  margin: 5px auto;
  border: 3px black solid;
  border-radius: 16px;
  display: flex;
  flex-direction: column;
}
.date {
  margin-left: 20px;
}
.title {
  width: 60%;
  height: 60px;
  margin-left: 50px;
  h3 {
    margin: 0;
  }
}
.content {
  width: 55%;
  height: 40px;
  margin-left: 60px;
  h6 {
    overflow: hidden;
    margin: 10px;
    font-size: 3rem;
  }
}

.pic {
  position: absolute;
  right: 30px;
  margin-top: 10px;
  img {
    width: 230px;
    height: 230px;
    border-radius: 50%;
    border: 3px solid black;
  }
}
</style>
