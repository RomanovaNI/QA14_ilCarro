package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.Car;
import com.ilCarro.qa14.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Lika", "Voronina", "1lv@lvl.ua", "123LikaVornina"});
        list.add(new Object[]{"Lika", "Voronina", "1lika@lvl.ua", "123LikaVoronina"});
        list.add(new Object[]{"Lika", "Voronina", "1voronina@lvl.ua", "123LikaVoronina"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_newCar.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Car().setCountry(split[0]).setAddress(split[1]).setDistance(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validRegisteredUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_RegisteredUser.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> invalidRegisteredUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_RegisteredUser.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
