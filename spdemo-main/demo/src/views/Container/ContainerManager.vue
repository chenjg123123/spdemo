<script setup>
import { Tabbar, TabbarItem, Icon } from 'vant'
</script>

<template>
  <keep-alive>
    <RouterView />
  </keep-alive>

  <div>
    <Tabbar route class="footer-tabbar">
      <TabbarItem replace to="/container/search">
        <Icon name="search" size="50px" />
      </TabbarItem>
      <TabbarItem replace to="/container/society">
        <Icon name="friends-o" size="50px" />
      </TabbarItem>
      <TabbarItem replace to="/container/chat">
        <Icon name="comment-o" size="50px" />
      </TabbarItem>
      <TabbarItem replace to="/container/self">
        <Icon name="user-o" size="50px" />
      </TabbarItem>
    </Tabbar>
  </div>
</template>

<style scoped lang="scss">
.footer-tabbar {
  position: fixed;
  bottom: 0;
  height: 70px; /* 调整高度 */
  display: flex;
  justify-content: space-around; /* 调整图标位置 */
  width: 100%;
}
</style>
