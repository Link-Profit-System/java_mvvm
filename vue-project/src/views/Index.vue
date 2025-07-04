<template>
  <div>
    <h1>Users</h1>
    <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>User Name</td>
          <td>Actions</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users" :key="user.id">
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