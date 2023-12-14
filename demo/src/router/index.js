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
      redirect: '/container',
      children: [
        {
          path: '/container',
          component: () => import('@/views/Container/ContainerManager.vue'),
          redirect: '/container/search',
          children: [
            {
              path: '/container/search',
              component: () => import('@/views/Container/ContainerSearch.vue')
            },
            {
              path: '/container/society/',
              component: () => import('@/views/Container/ContainerSociety.vue')
            },
            {
              path: '/container/society/:id',
              component: () => import('@/views/Container/ShowSocietyDetail.vue')
            },
            {
              path: '/container/self',
              component: () => import('@/views/Container/ContainerSelf.vue')
            },
            {
              path: '/container/chat',
              component: () => import('@/views/Container/ContainerChat.vue')
            },
            {
              path: '/container/searchkey/:key',
              component: () =>
                import('@/views/Container/ContainerSearchResult.vue')
            }
          ]
        }
      ]
    }
  ]
})

export default router
// path: '/container',
// component: () => import('@/views/Container/ContainerManager.vue'),
// redirect: '/container/search',
// children: [
//   {
//     path: '/container/search',
//     component: () =>
//       import('@/views/Container/Container/ContainerSearch.vue')
//   }
// ]
