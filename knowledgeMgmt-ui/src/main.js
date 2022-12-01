// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import {postRequest} from './utils/api'
import {getRequest} from './utils/api'

Vue.config.productionTip = false

Vue.prototype.postRequest = postRequest
Vue.prototype.getRequest = getRequest

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
