package com.dayshare.metadata;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "metadataCategoryProjection", types = {MetadataCategory.class})
public interface MetadataCategoryProjection {
    Long getMetadataCategory();
    String getName();
    String getDescription();
    String getNameFieldTitle();
    String getDescFieldTitle();
}
