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
            <label>User Name:</label>
            <input type="text" class="form-control" v-model="user.name" />
          </div>
          <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Update User" />
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

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
    }
  }
};
</script>