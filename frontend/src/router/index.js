import Vue from 'vue'
import Router from 'vue-router'
import VideoList from '@/components/VideoList'
import Video from '@/components/Video'
import Test from '@/components/test'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

Vue.use(Vuetify)
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/videoList',
      name: 'VideoList',
      component: VideoList
    },
    {
      path: '/video/:id',
      name: 'Video',
      component: Video
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    }

  ]
})
