<template>
  <Navbar v-if="$route.name !== 'Login'" />
  <div class="main-content">
    <router-view />
  </div>
</template>

<script setup lang="ts">
import Navbar from './components/Navbar.vue'
import { useRoute } from 'vue-router'
const $route = useRoute()
</script>

<style>
body, #app {
  display: block;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s
}
.fade-enter, .fade-leave-active {
  opacity: 0
}
.gap {
  margin-top: 50px;
}
.main-content {
  margin-top: 2rem; /* ナビバーとの間に余白 */
}
</style>
