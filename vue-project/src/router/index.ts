import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '../stores/auth'

const routes = [
  {
    name: 'Index',
    path: '/',
    component: () => import('../views/Index.vue'),
    meta: { requiresAuth: true }
  },
  {
    name: 'Create',
    path: '/create',
    component: () => import('../views/Create.vue')
  },
  {
    name: 'Edit',
    path: '/users/:id/edit',
    component: () => import('../views/Edit.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
  const auth = useAuthStore()
  if (to.meta.requiresAuth && !auth.isAuthenticated) {
    next({ name: 'Login' })
  } else {
    next()
  }
})

export default router
