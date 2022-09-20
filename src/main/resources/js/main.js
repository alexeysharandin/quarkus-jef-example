// Vue imports
import Vue from 'vue'
import vuetify from 'plugins/vuetify'

// Libraries imports
import 'core-js/stable';
import 'regenerator-runtime/runtime';

// Plugins imports
import 'plugins/axios'
import 'plugins/logger'

import store from 'plugins/store'
import App from 'pages/Application.vue'

new Vue({
    el: '#app',
    vuetify,
    store,
    render: a => a(App)
})
