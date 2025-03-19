<template id="add-tvseries-template">
  <p>Navigation Menu:</p>
  <ul>
    <li><a href="/">Home Page</a></li>
    <li><a href="/tvseries">TV Series Overview</a></li>
  </ul>
  <br>

  <h1>Create new TV Series</h1>
  <form action="/api/add-tvseries" method="post">
    <label for="title">Title: </label><br>
    <input type="text" id="title" name="title"><br>
    <label for="description">Description: </label><br>
    <input type="text" id="description" name="description"><br>
    <label for="release-date-day">Release Date Day of Month:</label><br>
    <input type="number" id="release-date-day" name="release-date-day"><br>
    <label for="release-date-month">Release Date Month: </label><br>
    <input type="number" id="release-date-month" name="release-date-month"><br>
    <label for="release-date-year">Release Date Year: </label><br>
    <input type="number" id="release-date-year" name="release-date-year"><br>
    <input type="submit" value="Create">
  </form>
</template>

<script>
  app.component("add-tvseries", {
    template: "#add-tvseries-template"
  })
</script>

<style>

</style>