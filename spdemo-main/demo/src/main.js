import './assets/main.scss'

import { createApp } from 'vue'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import Pinia from './stores'
import 'vant/lib/index.css'
import * as ELIcons from '@element-plus/icons-vue'

const app = createApp(App)
for (let iconName in ELIcons) {
  app.component(iconName, ELIcons[iconName])
}

app.use(Pinia)
app.use(router)
app.use(ElementPlus)
app.mount('#app')
