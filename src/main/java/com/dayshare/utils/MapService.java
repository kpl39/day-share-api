package com.dayshare.utils;


import com.dayshare.geolocation.GeoLocation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MapService {
    private GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyCHtSTmXxXyLjTuRAwpA6Ves2GammjotqM")
            .build();

    public GeoLocation getGeoLocation(String address) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GeoLocation geoLocation = new GeoLocation();
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            geoLocation.setAddress(address);
            geoLocation.setLatitude(results[0].geometry.location.lat);
            geoLocation.setLongitude(results[0].geometry.location.lng);
            System.out.println(gson.toJson(results[0]));
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return geoLocation;

    }

}
