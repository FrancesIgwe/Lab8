package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     * one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }


    /**
     * check if list contains a particular city
     */
    @Test
    public void hasCityTest() {
             CustomList cityList = MockCityList();

            // returns true if test city is in the list
            City testcity1 = new City("Toronto", "Ontario");
            cityList.addCity(testcity1);
            Assertions.assertTrue(cityList.hasCity(testcity1));

            // returns false if a test city is not in the list
            City testcity2 = new City("Calgary", "Alberta");
            assertFalse(cityList.hasCity(testcity2));
        }

    /**
     * deletes a city from list
     */
    @Test
    void testDeleteCity() {
        CustomList cityList = MockCityList();
        City city = new City("Toronto", "Ontario");

        cityList.addCity(city);
        Assertions.assertTrue(cityList.hasCity(city));

        cityList.delete(city);
        assertFalse(cityList.hasCity(city));

    }
    /** test cases for city count
     */

    @Test
    void testCountCities(){
        CustomList cityList = MockCityList();

        City city = new City("Toronto", "Ontario");
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Toronto", "Ontario");
        cityList.addCity(city);
        cityList.addCity(city2);
        cityList.addCity(city3);
        assertEquals(3, cityList.getCount());
        cityList.delete(city);
        assertEquals(2, cityList.getCount());

    }

    }




