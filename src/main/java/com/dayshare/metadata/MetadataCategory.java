package com.dayshare.metadata;

import com.dayshare.child.Child;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "metadata_categories")
public class MetadataCategory {
    @Id
    @GeneratedValue
    @Column(name = "metadata_category_id")
    private Long metadataCategory;
    private String name;
    private String description;
    @OneToMany(mappedBy="metadataCategory")
    private Set<ChildMetadata> childMetadata;

    public MetadataCategory() {}

    public MetadataCategory(Long metadataCategory, String name, String description) {
        this.metadataCategory = metadataCategory;
        this.name = name;
        this.description = description;
    }

    public Long getMetadataCategory() {
        return metadataCategory;
    }

    public void setMetadataCategory(Long metadataCategory) {
        this.metadataCategory = metadataCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
