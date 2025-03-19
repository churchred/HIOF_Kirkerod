<template id="tvseries-detail-template">
  <p>Navigation Menu:</p>
  <ul>
    <li><a href="/">Home Page</a></li>
    <li><a href="/tvseries">TV Series Overview</a></li>
    <li><a href="/add-tvseries">Add TV Series</a></li>
  </ul>
  <br>

  <h1 v-if="tvSeries.title">{{tvSeries.title}}</h1>
  <h1 v-else >TVSeries must have title</h1>
  <p><b>Description:</b> {{tvSeries.description}}</p>
  <p><b>Release date:</b> {{tvSeries.releaseDate[2]}}/{{tvSeries.releaseDate[1]}}/{{tvSeries.releaseDate[0]}}</p>
  <p><b>Number of seasons:</b> {{tvSeries.numSeasons}}</p>
  <p><b>Number of episodes:</b> {{tvSeries.episodes.length}}</p>
</template>

<script>
app.component("tvseries-detail", {
  template: "#tvseries-detail-template",
  data: () => ({
    tvSeries: {}
  }),
  created() {
    const tvSeriesName = this.$javalin.pathParams["tvseries-name"];

    fetch(`/api/tvseries/${tvSeriesName}`)
        .then(res => res.json())
        .then(res => {
          this.tvSeries = res
        })
        .catch(() => alert("Error when retrieving TV Series information."))
  }
})
</script>