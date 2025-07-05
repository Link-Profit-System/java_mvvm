<template>
  <div class="container">
    <h2>Login</h2>
    <form @submit.prevent="onLogin">
      <div class="mb-3">
        <label>Username</label>
        <input v-model="username" class="form-control" />
      </div>
      <div class="mb-3">
        <label>Password</label>
        <input v-model="password" type="password" class="form-control" />
      </div>
      <div v-if="error" class="alert alert-danger">{{ error }}</div>
      <button class="btn btn-primary">Login</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth'

const username = ref('')
const password = ref('')
const error = ref('')
const router = useRouter()
const auth = useAuthStore()

async function onLogin() {
  const ok = await auth.login(username.value, password.value)
  if (ok) {
    router.push({ name: 'Index' })
  } else {
    error.value = 'ログインに失敗しました'
  }
}
</script>