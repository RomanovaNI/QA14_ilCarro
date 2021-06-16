package com.ilCarro.qa14;

public class Car {
    private String country;
    private String address;
    private String distance;

    public Car setCountry(String country) {
        this.country = country;
        return this;
    }

    public Car setAddress(String address) {
        this.address = address;
        return this;
    }

    public Car setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }
}
