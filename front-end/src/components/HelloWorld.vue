<script setup>
import axios from "axios";
import { onMounted, ref } from 'vue';
const API_URL = "http://localhost:8080/api/v1.0"
const photos = ref();
const search = ref("");
const emptyMessage = {
  text: null,
  email: null
};
const newMessage = ref({ ...emptyMessage });

function storeMessage() {
  axios.post(API_URL + "/store", newMessage.value)
    .then(() => {
      newMessage.value = ref({ ...newMessage });
    })
    .catch(err => console.log(err));
}
function getPhotos(){
  axios.get(API_URL+"/all")
    .then(res => {

      const data = res.data;
      photos.value = data;
    })
    .catch(err => console.log(err));


}
function getPhotosSearch(){
  axios.post(API_URL+"/"+search.value)
    .then(res => {

      const data = res.data;
      photos.value = data;
    })
    .catch(err => console.log(err));


}
onMounted(() => {
  getPhotos()
})
  
</script>

<template>
  <form @submit.prevent=" getPhotosSearch()">
    <input type="text" name="title" v-model="search">
    <input type="submit" value="SEARCH">
  </form>
  <div class="container">
    <div class="row row-col-3">
      <div v-for="photo in photos" class="list-unstyled col ">
        <p>{{ photo.title }}</p>
        <img :src="photo.url" :alt="photo.title">
      </div>
    </div>
  </div>


  <h2>Whrite a Message to Admin</h2>
  <form @submit.prevent="storeMessage()">
    <div class="mb-3">
      <textarea class="form-control" name="text" id="text" rows="3" v-model="newMessage.text"></textarea>
    </div>
    <div class="mb-3">
      <input type="email" class="form-control" name="email" id="email" v-model="newMessage.email"
        aria-describedby="emailHelpId" placeholder="abc@mail.com">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</template>

<style scoped></style>
