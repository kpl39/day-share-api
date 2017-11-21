package com.dayshare.parent;

import com.dayshare.child.Child;
import com.dayshare.child.ChildRepositroy;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("api/parents")
public class ParentController {

    @Autowired
    private ParentRepository parentRepo;

    @Autowired
    private ChildRepositroy childRepo;


    @RequestMapping(value = "/addparent", method = RequestMethod.POST)
    public ResponseEntity<String> addParent(@RequestBody String parentInfo) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Gson jsonResponse = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Parent parent = gson.fromJson(parentInfo, Parent.class);

        Parent newParent = parentRepo.save(parent);

        Set<Child> children = parent.getChildren();

        for (Child child : children) {
            child.setParent(newParent);
            childRepo.save(child);
        }

        String parentResponse = jsonResponse.toJson(newParent);

        return new ResponseEntity<String>(parentResponse, HttpStatus.OK);
    }

}
