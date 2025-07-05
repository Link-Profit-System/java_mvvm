import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import axios from 'axios'
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'
import { useAuthStore } from './stores/auth'

axios.defaults.baseURL = 'http://localhost:8080'

const app = createApp(App)

app.config.globalProperties.$axios = axios

app.use(createPinia())
app.use(router)
app.use(VueSweetalert2)

app.mount('#app')

// 認証情報の復元
const auth = useAuthStore()
auth.restore()
