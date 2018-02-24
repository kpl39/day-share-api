package com.dayshare.socket;

import com.dayshare.parent.Parent;

import javax.persistence.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NamedEntityGraph(
        name = "AllSocketMembers",
        attributeNodes = {
                @NamedAttributeNode(value = "type"),
                @NamedAttributeNode(value = "members", subgraph = "membersGraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "membersGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "parentId")
                        }
                )
        }
)

@Table(name = "conversation_sockets")
public class ConversationSocket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socket_id")
    private Long socketId;
    private int type;
    @ManyToMany(mappedBy = "sockets")
    private List<Parent> parents = new ArrayList<Parent>();
    @OneToMany(mappedBy = "socket")
    private Set<SocketMembership> members;

    public ConversationSocket() {
    }

    public ConversationSocket(Long socketId, int type, List<Parent> parents, Set<SocketMembership> members) {
        this.socketId = socketId;
        this.type = type;
        this.parents = parents;
        this.members = members;
    }

    public Long getSocketId() {
        return socketId;
    }

    public void setSocketId(Long socketId) {
        this.socketId = socketId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public Set<SocketMembership> getMembers() {
        return members;
    }

    public void setMembers(Set<SocketMembership> members) {
        this.members = members;
    }
}
