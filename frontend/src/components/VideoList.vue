<template>
  <v-app id="inspire">
    <v-layout align-start justify-start column fill-height>
      <v-flex xs14 sm14 offset-sm3>
        <v-card>
          <!-- <v-toolbar color="light-blue" dark>
            <v-toolbar-side-icon></v-toolbar-side-icon>
            <v-toolbar-title>My Videos</v-toolbar-title>
          </v-toolbar> -->

          <v-list two-line subheader>
            <!-- <v-divider inset></v-divider> -->

            <v-subheader inset>Videos</v-subheader>

            <v-list-tile
              v-for="item in items"
              :key="item._id"
              avatar
              :to="{path: '/video/' + item._id}"
            >
              <v-list-tile-avatar>
                <v-icon class="blue white--text">play_circle_filled</v-icon>
              </v-list-tile-avatar>

              <v-list-tile-content>
                <v-list-tile-title>{{ item.filename }}</v-list-tile-title>
                <v-list-tile-sub-title>{{ item.uploadDate }}</v-list-tile-sub-title>
              </v-list-tile-content>

              <v-list-tile-action>
                <v-btn icon ripple>
                  <v-icon color="grey lighten-1">info</v-icon>
                </v-btn>
              </v-list-tile-action>
            </v-list-tile>
          </v-list>
        </v-card>
      </v-flex>
    </v-layout>
  </v-app>
</template>

<script>
import {AXIOS} from './http-common'
export default {
  name: 'HelloWorld',
  icon: 'play_circle_filled',
  iconclass: 'blue white--text',
  data () {
    return {
      items: []
    }
  },
  created: function () {
    AXIOS.get(`/video/list`)
      .then(response => {
        this.items = response.data
      })
      .catch(e => {
        alert('rest call fail')
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
