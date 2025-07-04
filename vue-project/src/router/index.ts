import { createRouter, createWebHistory } from 'vue-router'
import Create from '../views/Create.vue'
import Edit from '../views/Edit.vue'
import Index from '../views/Index.vue'

const routes = [
  {
    name: 'Index',
    path: '/',
    component: Index
  },
  {
    name: 'Create',
    path: '/create',
    component: Create
  },
  {
    name: 'Edit',
    path: '/users/:id/edit',
    component: Edit
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
