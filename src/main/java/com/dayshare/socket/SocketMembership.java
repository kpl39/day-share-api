package com.dayshare.socket;

import javax.persistence.*;

@Entity
@Table(name = "socket_membership")
public class SocketMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id")
    private Long membershipId;
    @Column(name = "parent_id")
    private int parentId;
    @Column(name = "socket_id", insertable = false, updatable = false)
    private int socketId;
    @ManyToOne
    @JoinColumn(name = "socket_id", nullable = false)
    private ConversationSocket socket;

    public SocketMembership() {
    }

    public SocketMembership(int parentId, int socketId, ConversationSocket socket) {
        this.parentId = parentId;
        this.socketId = socketId;
        this.socket = socket;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSocketId() {
        return socketId;
    }

    public void setSocketId(int socketId) {
        this.socketId = socketId;
    }

    public ConversationSocket getSocket() {
        return socket;
    }

    public void setSocket(ConversationSocket socket) {
        this.socket = socket;
    }
}
