<template>
  <div>
    <div class="d-flex align-items-center mb-3">
      <h1 class="me-3">Users</h1>
      <router-link to="/create" class="btn btn-success">ユーザ作成</router-link>
    </div>
    <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>User Name</td>
          <td>Actions</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users" :key="user.id" class="align-middle">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>
            <router-link :to="{name: 'Edit', params: { id: user.id }}" class="btn btn-primary">Edit</router-link>
            <button class="btn btn-danger ms-2" @click="deleteUser(user.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import { useAuthStore } from '../stores/auth'

const auth = useAuthStore()

export default {
  data() {
    return {
      users: []
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    fetchUsers() {
      axios.get('/users/list')
        .then(response => {
          this.users = response.data;
        });
    },
    deleteUser(id) {
      axios.delete(`/users/${id}`)
        .then(() => {
          this.fetchUsers();
        });
    }
  }
};
</script>