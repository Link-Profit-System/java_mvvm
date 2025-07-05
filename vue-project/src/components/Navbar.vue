<template>
  <nav class="navbar navbar-expand navbar-light bg-light">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">Home</router-link>
      <div class="d-flex align-items-center ms-auto">
        <span
          v-if="auth.isAuthenticated"
          class="me-2 align-self-center"
        >Hello, {{ auth.user?.name }}</span>
        <button
          v-if="auth.isAuthenticated"
          class="btn btn-outline-secondary align-self-center"
          @click="logout"
        >Logout</button>
        <router-link
          v-else
          to="/login"
          class="btn btn-primary align-self-center"
        >Login</router-link>
      </div>
    </div>
  </nav>
</template>
<script setup lang="ts">
import { useAuthStore } from '../stores/auth'
import { useRouter } from 'vue-router'
const auth = useAuthStore()
const router = useRouter()
function logout() {
  auth.logout()
  router.push({ name: 'Login' })
}
</script>