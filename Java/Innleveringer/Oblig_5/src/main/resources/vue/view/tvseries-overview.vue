<template id="tvseries-overview-template">
    <nav>
    <p>Linjeforeningen</p>
      <ul>
        <li><a href="/">Home Page</a></li>
        <li><a href="/tvseries">TV Series Overview</a></li>
        <li><a href="/add-tvseries">Add TV Series</a></li>
      </ul>
    </nav>
  <br>

  <h1>All TV Series</h1>
  <ul class="list">
    <li v-for="tvSeries in listOfTVSeries" class="list-element">
      <h2><a :href="`/tvseries/${tvSeries.title}`">{{tvSeries.title + " - Seasons: " + tvSeries.numSeasons}}</a></h2>
      <!--
      <ul>
        <li>{{tvSeries.description}}</li>
      </ul>
      -->
      <p><b>Description:</b> {{tvSeries.description}}</p>
    </li>
  </ul>
</template>

<script>
app.component("tvseries-overview", {
  template: "#tvseries-overview-template",
  data: () => ({
    listOfTVSeries: []
  }),
  created() {
    fetch(`/api/tvseries`)
        .then(res => res.json())
        .then(res => {
          this.listOfTVSeries = res
        })
        .catch(() => alert("Error while fetching all TV Series."))
  }
})
</script>

<style>

    .list{
        margin:auto;
        list-style-type: none;
    }

    .list li{
        margin-top: 20px;
        padding: 10px;
        color: black;
        border: black solid 2px;
        border-radius: 4px;
        background-color: white;
        box-shadow: 1px 1px 5px black;
    }

    .list li h2{
        margin-bottom: 10px;
    }

    .list li a:hover{
        color:rgb(196, 22, 57);
    }




</style>