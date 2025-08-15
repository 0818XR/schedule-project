import { createApp } from 'vue'
import App from './App.vue'
// 导入路由
import router from './router/router.js'
// 导入pinia对象
import pinia from './pinia.js'
let app =createApp(App)
// 全局使用路由
app.use(router)
// 全局使用pinia
app.use(pinia)
app.mount('#app')