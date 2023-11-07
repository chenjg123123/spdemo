import { createPinia } from 'pinia'
import persist from 'pinia-plugin-persistedstate'
const Pinia = createPinia()
Pinia.use(persist)
export default Pinia

export * from './modules/user'
