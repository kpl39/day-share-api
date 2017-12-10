package com.dayshare.geolocation;

import com.dayshare.utils.MapService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/geolocation")
public class GeoLocationController {


    @RequestMapping(value = "/getgeolocation", method = RequestMethod.POST)
    public ResponseEntity<String> addParent(@RequestBody String address) {
        Gson gson = new Gson();
        Map addressMap = gson.fromJson(address, Map.class);

        MapService mapService = new MapService();
        GeoLocation geoLocation = mapService.getGeoLocation(addressMap.get("address").toString());

        String jsonResponse = gson.toJson(geoLocation);

        return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);
    }

}
