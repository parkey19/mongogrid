<template>
  <div id="app">
    <v-app
      id="inspire"
      dark
    >
      <v-navigation-drawer
        v-model="drawer"
        fixed
        clipped
        app
      >
        <v-list dense>
          <v-list-tile v-for="item in items" :key="item.text" :to="{path: item.url}">
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
      <v-toolbar
        color="red"
        dense
        fixed
        clipped-left
        app
      >
        <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
        <v-icon class="mx-3">fab fa-youtube</v-icon>
        <v-toolbar-title class="mr-5 align-center">
          <span class="title">Ytube</span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-layout row align-center style="max-width: 650px">
          <v-text-field
            :append-icon-cb="() => {}"
            placeholder="Search..."
            single-line
            append-icon="search"
            color="white"
            hide-details
          ></v-text-field>
        </v-layout>
      </v-toolbar>
      <v-content>
        <v-container fill-height>
          <v-layout justify-center align-center>
            <router-view/>
            <v-flex shrink>
              <!-- content router view -->

            </v-flex>
          </v-layout>
        </v-container>
      </v-content>
    </v-app>

  </div>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    drawer: null,
    items: [
      { icon: 'featured_play_list', text: 'Playlists', url: '/videoList' }
      // { icon: 'trending_up', text: 'Most Popular' },
      // { icon: 'subscriptions', text: 'Subscriptions' },
      // { icon: 'history', text: 'History' },
      // { icon: 'watch_later', text: 'Watch Later' }
    ]
  }),
  props: {
    source: String
  }
}
</script>

<style>
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
