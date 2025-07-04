<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Add User</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="addUser">
          <div v-show="message" class="alert alert-danger">{{message}}</div>
          <div class="form-group">
            <label>User Name:</label>
            <input type="text" class="form-control" v-model="user.name" />
          </div>
          <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Add User" />
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
      message: "",
      isError: false
    };
  },
  methods: {
    addUser() {
      const uri = "/users";
      axios
        .post(uri, this.user)
        .then(() => {
          this.$swal({
            icon: "success",
            text: "Created Success!"
          });
            this.$router.push({ name: "Index" });
        })
        .catch(error => {
          this.message = `status: ${error.response.status}, message: ${error.response.data}`;
        });
    }
  }
};
</script>