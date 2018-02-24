package com.dayshare.socket;

import com.dayshare.parent.Parent;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.Set;

@Projection(name = "socketProjection", types = {ConversationSocket.class})
public interface SocketProjection {
    Long getSocketId();
    int getType();
    List<Parent> getParents();
    Set<SocketMembership> getMembers();
}
