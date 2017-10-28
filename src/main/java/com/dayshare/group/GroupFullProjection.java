package com.dayshare.group;

import com.dayshare.parent.Parent;
import com.dayshare.parent.ParentFullProjection;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "groupFullProjection", types = {Group.class})
public interface GroupFullProjection {
    Long getGroupId();
    String getName();
    Set<ParentFullProjection> getParents();
}
