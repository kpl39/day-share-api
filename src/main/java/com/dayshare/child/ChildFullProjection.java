package com.dayshare.child;


import com.dayshare.metadata.ChildMetadata;
import com.dayshare.metadata.ChildMetadataProjection;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.Set;

@Projection(name = "childFullProjection", types = {Child.class})
public interface ChildFullProjection {
    Long getChildId();
    String getFirstName();
    String getLastName();
    String getGender();
    Date getBirthDate();
    Set<ChildMetadataProjection> getChildMetadata();
}
