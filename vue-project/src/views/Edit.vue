<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Edit User</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="updateUser">
          <div v-show="message" class="alert alert-danger">{{message}}</div>
          <div class="form-group">
            <label>Password:</label>
            <input type="text" class="form-control" v-model="user.password" />
          </div>
          <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" v-model="user.name" />
          </div>
          <div class="form-group mt-3">
            <input type="submit" class="btn btn-primary me-2" value="Update User" />
            <button type="button" class="btn btn-secondary" @click="cancel">キャンセル</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { useAuthStore } from '../stores/auth'

const auth = useAuthStore()

export default {
  data() {
    return {
      user: {},
      message: ""
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
      const uri = `/users/${this.$route.params.id}`;
      axios.get(uri)
        .then(response => {
          this.user = response.data;
        })
        .catch(error => {
          this.message = `status: ${error.response?.status}, message: ${error.response?.data}`;
        });
    },
    updateUser() {
      const uri = `/users/${this.$route.params.id}`;
      axios.put(uri, this.user)
        .then(() => {
          this.$swal({
            icon: "success",
            text: "Updated Success!"
          });
          this.$router.push({ name: "Index" });
        })
        .catch(error => {
          this.message = `status: ${error.response?.status}, message: ${error.response?.data}`;
        });
    },
    cancel() {
      this.$router.push({ name: "Index" });
    }
  }
};
</script>