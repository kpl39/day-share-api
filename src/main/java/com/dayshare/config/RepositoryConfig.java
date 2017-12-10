package com.dayshare.config;

import com.dayshare.availabilty.ParentAvailability;
import com.dayshare.child.Child;
import com.dayshare.group.Group;
import com.dayshare.metadata.ChildMetadata;
import com.dayshare.metadata.MetadataCategory;
import com.dayshare.parent.Parent;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Parent.class);
        config.exposeIdsFor(Child.class);
        config.exposeIdsFor(Group.class);
        config.exposeIdsFor(ChildMetadata.class);
        config.exposeIdsFor(MetadataCategory.class);
        config.exposeIdsFor(ParentAvailability.class);
    }
}