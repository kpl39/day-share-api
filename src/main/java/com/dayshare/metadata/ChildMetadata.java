package com.dayshare.metadata;


import com.dayshare.child.Child;
import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "child_metadata")
public class ChildMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_metadata_id")
    @Expose
    private Long childMetadataId;
    @ManyToOne
    @JoinColumn(name="child_id", nullable=false)
    private Child child;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_category_id")
    @Expose
    private MetadataCategory metadataCategory;
    @Expose
    private String name;
    @Expose
    private String description;

    public ChildMetadata() {}

    public ChildMetadata(Long childMetadataId, Child child, MetadataCategory metadataCategory, String name, String description) {
        this.childMetadataId = childMetadataId;
        this.child = child;
        this.metadataCategory = metadataCategory;
        this.name = name;
        this.description = description;
    }

    public Long getChildMetadataId() {
        return childMetadataId;
    }

    public void setChildMetadataId(Long childMetadataId) {
        this.childMetadataId = childMetadataId;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public MetadataCategory getMetadataCategory() {
        return metadataCategory;
    }

    public void setMetadataCategory(MetadataCategory metadataCategory) {
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

//     compile group: 'com.amazonaws', name: 'aws-java-sdk-s3', version: '1.11.200'