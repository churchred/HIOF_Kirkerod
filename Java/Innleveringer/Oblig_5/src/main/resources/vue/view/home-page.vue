<template id="home-page-template">
    <nav>
    <p>Linjeforeningen</p>
      <ul>
        <li><a href="/">Home Page</a></li>
        <li><a href="/tvseries">TV Series Overview</a></li>
        <li><a href="/add-tvseries">Add TV Series</a></li>
      </ul>
    </nav>

  <h1>Welcome to the TV Series register!</h1>
</template>

<script>
  app.component("home-page", {
    template: "#home-page-template"
  })
</script>

<style >
    h1{
        font-size: 4rem;
        margin: auto;
        height: 500px;
        line-height: 500px;
        text-align: center;
    }
</style>