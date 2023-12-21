import { createPinia } from 'pinia'
import persist from 'pinia-plugin-persistedstate'

const Pinia = createPinia()
Pinia.use(persist)
Pinia.use(({ store }) => {
  const initialState = JSON.parse(JSON.stringify(store.$state))
  store.$reset = () => {
    store.$patch(initialState)
  }
})
export default Pinia

export * from './modules/user'
