package com.dayshare.parent;

import com.dayshare.child.Child;
import com.dayshare.group.Group;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="parent_id")
    @Expose
    private Long parentId;
    @Column(name= "user_id")
    @Expose
    private String userId;
    @Expose
    private String email;
    @Expose
    private String username;
    @Column(name= "first_name")
    @Expose
    private String firstName;
    @Column(name= "last_name")
    @Expose
    private String lastName;
    @OneToMany(mappedBy="parent")
    private Set<Child> children;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name= "Group_Membership",
            joinColumns = { @JoinColumn(name = "parent_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    private List<Group> groups = new ArrayList<Group>();
    @Expose
    private String address1;
    @Expose
    private String address2;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String zipcode;
    @Expose
    private double latitude;
    @Expose
    private double longitude;
    @Column(name= "profile_image_url")
    @Expose
    private String profileImageUrl;
    @Column(name= "facebook_id")
    @Expose
    private String facebookId;
    @Column(name= "twitter_id")
    @Expose
    private String twitterId;
    @Expose
    private String description;

    public Parent() {}

    public Parent(String userId, String email, String username, String firstName, String lastName, Set<Child> children, List<Group> groups, String address1, String address2, String city, String state, String zipcode, double latitude, double longitude, String profileImageUrl, String facebookId, String twitterId, String description) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.children = children;
        this.groups = groups;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.profileImageUrl = profileImageUrl;
        this.facebookId = facebookId;
        this.twitterId = twitterId;
        this.description = description;
    }


//    public Parent(Long parentId, String userId, String email, String username, String firstName, String lastName, Set<Child> children, String address1, String address2, String city, String state, String zipcode, String profileImageUrl, String facebookId, String twitterId) {
//        this.parentId = parentId;
//        this.userId = userId;
//        this.email = email;
//
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.children = children;
//        this.address1 = address1;
//        this.address2 = address2;
//        this.city = city;
//        this.state = state;
//        this.zipcode = zipcode;
//        this.profileImageUrl = profileImageUrl;
//        this.facebookId = facebookId;
//        this.twitterId = twitterId;
//    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
