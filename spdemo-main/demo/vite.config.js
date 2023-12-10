import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    AutoImport({
      resolvers: [ElementPlusResolver()]
    }),
    Components({
      resolvers: [ElementPlusResolver()]
    })
  ],
  base: '/',
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: { //同plugins同级
    port: 8181,
    // 默认是5173,这里可以自己指定
    // 代理解决跨域
    proxy: {
      '/api': {
        target: 'http://localhost:8080/sys/',  // 接口源地址
        changeOrigin: true,   // 开启跨域
        rewrite: (path) => path.replace(/^\/api/, ''),
      }
    }
  }
})
