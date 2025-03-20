<template id="add-tvseries-template">
    <nav>
    <p>Linjeforeningen</p>
      <ul>
        <li><a href="/">Home Page</a></li>
        <li><a href="/tvseries">TV Series Overview</a></li>
        <li><a href="/add-tvseries">Add TV Series</a></li>
      </ul>
    </nav>

  <br>

    <h1>Create new TV Series</h1>
    <form action="/api/add-tvseries" method="post">
      <label for="title">Title: </label><br>
      <input type="text" id="title" name="title"><br>

      <label for="description">Description: </label><br>
      <textarea id="description" name="description" class="big"></textarea><br>

      <label for="release-date-day">Release Date Day of Month:</label><br>
      <input type="number" id="release-date-day" name="release-date-day" min="1"><br>

      <label for="release-date-month">Release Date Month: </label><br>
      <input type="number" id="release-date-month" name="release-date-month" min="1"><br>

      <label for="release-date-year">Release Date Year: </label><br>
      <input type="number" id="release-date-year" name="release-date-year" min="1"><br>

      <input class="submit" type="submit" value="Create">
    </form>
</template>

<script>
  app.component("add-tvseries", {
    template: "#add-tvseries-template"
  })
</script>

<style>
    form{
        margin:auto;
        display:grid;
    }

    label{
        text-transform: UPPERCASE;
        margin-top:20px;
    }

    input{
        width: 300px;
        height: 30px;
        border-radius: 3px;
    }

    .big{
          width: 100%;
          height: 100px;
          border-radius: 3px;
    }

    .submit{
        margin-top: 20px;
        cursor: pointer;
        border-radius: 3px;
        border: solid 1px black;
        transition: .1s linear;
        font-size: 16px;

        background-color: black;
        color:white;
    }

    .submit:hover{
        background-color: rgb(20,20,20);
        color:rgb(228, 106, 112);
    }

</style>