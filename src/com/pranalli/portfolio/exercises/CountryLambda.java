package com.pranalli.portfolio.exercises;

import java.util.List;

public class CountryLambda {
    static class Country {

        String continent;
        int population;
        Country(String continent, int population) {
            this.continent = continent;
            this.population = population;

        }
        String getContinent() {
            return continent;
        }

        int getPopulation() {
            return population;
        }

    }

    public static int totalPopulation(List<Country> countries, String continent) {
        return countries
                .stream()
                .filter(c -> c.getContinent().equals(continent))
                .map(Country::getPopulation)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        Country usa = new Country("North America", 3000000);
        Country mex = new Country("North America", 4000000);
        Country peru = new Country("South America", 999999);

        System.out.println(totalPopulation(List.of(usa, mex, peru), "North America"));
    }
}
