<template>
  <div>
    <p> test test </p>
    <button @click="callRestService()">call</button>
  </div>
</template>

<script>
import {AXIOS} from './http-common'
export default {
  name: 'HelloWorld',
  methods: {
    callRestService () {
      AXIOS.get(`/video/list`)
        .then(response => {
          console.dir(response.data)
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>
