package com.dayshare.metadata;

import com.dayshare.child.Child;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "childMetadataProjection", types = {ChildMetadata.class})
public interface ChildMetadataProjection {
    Long getChildMetadataId();
    String getName();
    String getDescription();
    MetadataCategoryProjection getMetadataCategory();
}
