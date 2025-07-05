import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useAuthStore = defineStore('auth', () => {
  const user = ref(null)
  const isAuthenticated = ref(false)
  const token = ref('')

  async function login(username: string, password: string) {
    try {
      const res = await axios.post('/auth/login', { username, password })
      user.value = res.data.user
      token.value = res.data.token
      isAuthenticated.value = true
      // JWTトークンをaxiosのデフォルトヘッダーにセット
      axios.defaults.headers.common['Authorization'] = `Bearer ${token.value}`
      // 必要ならlocalStorageにも保存
      localStorage.setItem('token', token.value)
      localStorage.setItem('user', JSON.stringify(user.value))
      return true
    } catch (e) {
      isAuthenticated.value = false
      user.value = null
      token.value = ''
      return false
    }
  }

  function logout() {
    user.value = null
    token.value = ''
    isAuthenticated.value = false
    delete axios.defaults.headers.common['Authorization']
    localStorage.removeItem('token')
    localStorage.removeItem('user')
  }

  // ページリロード時にlocalStorageから復元
  function restore() {
    const t = localStorage.getItem('token')
    const u = localStorage.getItem('user')
    if (t && u) {
      token.value = t
      user.value = JSON.parse(u)
      isAuthenticated.value = true
      axios.defaults.headers.common['Authorization'] = `Bearer ${token.value}`
    }
  }

  return { user, isAuthenticated, token, login, logout, restore }
})