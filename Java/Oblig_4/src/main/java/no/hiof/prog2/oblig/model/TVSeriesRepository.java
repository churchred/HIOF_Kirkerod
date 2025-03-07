package no.hiof.prog2.oblig.model;



// Definer et interface med navn TVSeriesRepository.
// Dette interfacet skal fungere som en "kontrakt" på hvilke
// metoder som må implementeres i forbindelse med lagring og uthenting av TVSeries-objekter.
//
// Interfacet skal altså kunne bli implementert i flere forskjellige klasser som håndter
// forskjellige typer lagringer av TVSeries-objekter, f.eks fillagring med CSV eller JSON,
// eller databaselagring (selv om vi ikke skal benytte eller implementere databaser i denne obligen).
//
// Start med å definere følgende abstrakte metoder i interfacet (altså uten implementasjon):
//
// addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries) -
// Skal ta imot en ArrayList med TVSeries-objekter og lagre disse.

// getAllTVSeries() -
// Skal returnere en ArrayList med alle lagrede TVSeries-objekter

// getTVSeriesByTitle(String title) -
// Skal returnere et TVSeries-objekt basert på den spesifiserte tittelen.


import java.util.ArrayList;

interface TVSeriesRepository {

    // Skal ta imot en ArrayList med TVSeries-objekter og lagre disse
    abstract void addListOfTVSeries(ArrayList<TVSeries> listOfTVSeries);

    // Skal returnere en ArrayList med alle lagrede TVSeries-objekter
    abstract ArrayList<TVSeries> getAllTVSeries();

    // Skal returnere et TVSeries-objekt basert på den spesifiserte tittelen.
    abstract TVSeries getTVSeriesByTitle(String title);

}
