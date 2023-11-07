import './assets/main.scss'

import { createApp } from 'vue'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import Pinia from './stores'
const app = createApp(App)

app.use(Pinia)
app.use(router)
app.use(ElementPlus)
app.mount('#app')
