import {createRouter,createWebHashHistory} from 'vue-router'


import pinia from '../pinia.js'
import {defineUser} from '../store/userStore.js'

let sysUser = defineUser(pinia)

import Login from '../components/Login.vue'
import Regist from '../components/Regist.vue'
import ShowScedule from '../components/ShowSchedule.vue'

let  router = createRouter({
    history:createWebHashHistory(),
    routes:[
        {
            path:"/",
            component:Login
        },
        {
            path:"/login",
            component:Login
        },
        {
            path:"/showSchedule",
            component:ShowScedule
        },
        {
            path:"/regist",
            component:Regist
        }
    ]
})
/* 配置路由的前置守卫,在登录状态下才可以范文showSchedule.vue */
router.beforeEach( (to,from,next) =>{
    // 如果是查看日程
    if(to.path=="/showSchedule"){
        // 如果尚未的登录
        if(sysUser.username == ''){
            alert("您尚未登录,请登录后再查看日程")
            next("/login")
        }else{
            // 已经登录 放行
            next()
        }
        // 其他资源 放行
    }else{
        next()
    }
})
export default router