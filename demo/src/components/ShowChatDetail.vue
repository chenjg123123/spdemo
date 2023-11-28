<script setup></script>
<template>
  <el-drawer title="userName" size="60%" style="margin-bottom: 5px">
    <div class="chat">
      <el-scrollbar>
        <div
          :class="{ chatDetail: true, user: false, oth: true }"
          v-for="index in 60"
        >
          <img src="@/assets/backgroud/b1.jpg" />
          <span>123</span>
        </div>
      </el-scrollbar>
    </div>

    <div class="box">
      <el-input :autosize="{ minRows: 4, maxRows: 6 }" type="textarea" />
    </div>
  </el-drawer>
</template>

<style scoped lang="scss">
.box {
  position: fixed;
  width: 60%;
  bottom: 10px;
  .el-textarea {
    width: 92%;
  }
}
.chat {
  display: flex;
  flex-direction: column;
  position: relative;
  height: 85%;
  overflow: auto;
  .chatDetail {
    height: 60px;
    margin: 3%;
    background: linear-gradient(to right, #ffffff, #f5f5f5);
  }

  img {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    margin: 5px 5px;
  }
  span {
    margin: 5px 10px;
  }
}
.user {
  display: flex;
  justify-content: flex-end;
}

.oth {
  display: flex;
  justify-content: flex-start;
}
</style>
