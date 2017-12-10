package com.dayshare.parent;

import com.dayshare.availabilty.ParentAvailability;
import com.dayshare.child.Child;
import com.dayshare.child.ChildFullProjection;
import com.dayshare.group.Group;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.Set;

@Projection(name = "parentFullProjection", types = {Parent.class})
public interface ParentFullProjection {
    Long getParentId();
    String getUserId();
    String getEmail();
    String getUsername();
    String getFirstName();
    String getLastName();
    Set<ChildFullProjection> getChildren();
    List<Group> getGroups();
    String getAddress1();
    String getAddress2();
    String getCity();
    String getState();
    String getZipcode();
    String getProfileImageUrl();
    String getFacebookId();
    String getTwitterId();
    String getDescription();
    double getLatitude();
    double getLongitude();
    ParentAvailability getAvailability();
}
