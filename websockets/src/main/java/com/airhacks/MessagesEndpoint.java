
package com.airhacks;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
@ServerEndpoint("/messages")
public class MessagesEndpoint {

    private Session session;

    @OnOpen
    public void onNewClient(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("message = " + message);
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText("Echo: " + message);
            } catch (IOException ex) {
                Logger.getLogger(MessagesEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



    @Schedule(hour = "*", minute = "*", second = "*/5")
    public void sendMessages() {
        System.out.println("-- executed: " + new Date());
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText("Hello from server: " + System.currentTimeMillis());
            } catch (IOException ex) {
                Logger.getLogger(MessagesEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


}
