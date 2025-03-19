<template id="home-page-template">
  <h1>Welcome to the TV Series register!</h1>
  <h2>We currently have two primary pages:</h2>
  <ol>
    <li><h3><a href="/tvseries">TV Series Overview</a>: Here you can view all our registered TV Series.</h3></li>
    <li><h3><a href="/add-tvseries">Create new TV Series</a>: Here you can add a new TV Series to the register.</h3></li>
  </ol>
</template>

<script>
  app.component("home-page", {
    template: "#home-page-template"
  })
</script>

<style >

</style>