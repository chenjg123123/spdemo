import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      component: () => import('@/views/Layout/LayoutLogin.vue')
    },
    {
      path: '/',
      component: () => import('@/views/Layout/LayoutContainer.vue'),
      redirect: '/container/manager',
      children: [
        {
          path: '/container/manager',
          component: () => import('@/views/Container/ContainerManager.vue')
        }
      ]
    }
  ]
})

export default router
