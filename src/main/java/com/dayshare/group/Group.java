package com.dayshare.group;

import com.dayshare.child.Child;
import com.dayshare.events.Event;
import com.dayshare.parent.Parent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedEntityGraph(
        name = "AllGroupMembers",
        attributeNodes = {
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "parents", subgraph = "parentsGraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "parentsGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "parentId"),
                                @NamedAttributeNode(value = "children")
                        }
                )
        }

)
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "group_id")
    private Long groupId;
    private String name;
    @ManyToMany(mappedBy = "groups")
//    private Set<Parent> parents = new HashSet<>();
    private List<Parent> parents = new ArrayList<Parent>();
    @OneToMany(mappedBy = "group")
    private Set<Event> events;

    public Group() {}

    public Group(Long groupId, String name, List<Parent> parents) {
        this.groupId = groupId;
        this.name = name;
        this.parents = parents;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }
}
