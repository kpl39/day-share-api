package com.dayshare.metadata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("api/childmetadata")
public class ChildMetadataController {
    @Autowired
    private ChildMetadataRepository metaRepo;

    @Autowired
    private MetadataCategoryRepository categoryRepo;


    @RequestMapping(value = "/editrecord/{recordId}", method = RequestMethod.PUT)
    public ResponseEntity<String> editRecord(@PathVariable Long recordId, @RequestBody String metaInfo) {
        Gson gson = new Gson();
        Gson jsonResponse = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Map metaMap = gson.fromJson(metaInfo, Map.class);

        Long categoryId = (long)Double.parseDouble(metaMap.get("metadataCategory").toString());

        MetadataCategory category = categoryRepo.findOne(categoryId);
        ChildMetadata metadata = metaRepo.findOne(recordId);

        metadata.setName(metaMap.get("name").toString());
        metadata.setDescription(metaMap.get("description").toString());
        metadata.setMetadataCategory(category);

        metaRepo.save(metadata);

        String response = jsonResponse.toJson(metadata);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
