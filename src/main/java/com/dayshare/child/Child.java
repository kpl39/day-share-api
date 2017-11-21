package com.dayshare.child;

import com.dayshare.metadata.ChildMetadata;
import com.dayshare.parent.Parent;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "child_id")
    private Long childId;
    @Column(name= "first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name="parent_id", nullable=false)
    private Parent parent;
    private String gender;
    @Column(name= "birth_date")
    private Date birthDate;
    @OneToMany(mappedBy="child")
    private Set<ChildMetadata> childMetadata;

    public Child() {}

    public Child(Long childId, String firstName, String lastName, Parent parent, String gender, Date birthDate) {
        this.childId = childId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parent = parent;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ChildMetadata> getChildMetadata() {
        return childMetadata;
    }

    public void setChildMetadata(Set<ChildMetadata> childMetadata) {
        this.childMetadata = childMetadata;
    }
}


