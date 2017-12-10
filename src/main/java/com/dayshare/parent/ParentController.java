package com.dayshare.parent;

import com.dayshare.child.Child;
import com.dayshare.child.ChildRepositroy;
import com.dayshare.geolocation.GeoLocation;
import com.dayshare.utils.MapService;
import com.dayshare.utils.s3.S3Services;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import java.util.Date;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("api/parents")
public class ParentController {

    @Autowired
    private ParentRepository parentRepo;

    @Autowired
    private ChildRepositroy childRepo;

    @Autowired
    private S3Services s3Services;


    @RequestMapping(value = "/addparent", method = RequestMethod.POST)
    public ResponseEntity<String> addParent(@RequestBody String parentInfo) {
        //Prepare Json
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Gson jsonResponse = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        MapService mapService = new MapService();

        Parent parent = gson.fromJson(parentInfo, Parent.class);
        //Prepare Address for Google Geocode API
        String fullAddress = parent.getAddress1() + " " + parent.getCity() + ", " + parent.getState() + " " + parent.getZipcode();
        //Get Lat Lng from Geocodes API and set to Parent
        GeoLocation geoLocation = mapService.getGeoLocation(fullAddress);
        parent.setLatitude(geoLocation.getLatitude());
        parent.setLongitude(geoLocation.getLongitude());

        Parent newParent = parentRepo.save(parent);

        Set<Child> children = parent.getChildren();

        for (Child child : children) {
            child.setParent(newParent);
            childRepo.save(child);
        }

        String parentResponse = jsonResponse.toJson(newParent);

        return new ResponseEntity<String>(parentResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateprofileimage", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProfileImage(@RequestBody String image) {
        Date date = new Date();
        long timestamp = date.getTime();
        Gson jsonResponse = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Map imageInfo = new Gson().fromJson(image, Map.class);

        String base64Image = imageInfo.get("image").toString();
        System.out.println("Parent ID" + imageInfo.get("parentId").toString());
        Long parentId = (long)Double.parseDouble(imageInfo.get("parentId").toString());
        String userId = imageInfo.get("userId").toString();

        String keyName = "profileImages/" + "user-" + userId + "/" + timestamp;

        String response = s3Services.uploadProfileImage(keyName, base64Image);
        System.out.println("Response from S3: " + response);

        String url = "https://s3.us-east-2.amazonaws.com/dayshare/" + keyName;

        Parent parent = parentRepo.findOne(parentId);
        parent.setProfileImageUrl(url);
        parentRepo.save(parent);


        String parentResponse = jsonResponse.toJson(parent);

        return new ResponseEntity<String>(parentResponse, HttpStatus.OK);
    }

}
