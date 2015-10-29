package com.ssh.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

@ParentPackage("basePackage")
@Namespace("/")
@ServerEndpoint(value = "/ws/chat/{nickName}")
public class TestWebSocketAction {

	@Action(value="test", results={@Result(name="success", location="/test.html")})
	public String getIndex(){
		return "success";
	}
	
	@Action(value="add")
	public void saveOrder(){
		System.out.println("i am in TestWebSocket add");
	}
	
    /**
     * 连接对象集合
     */
    private static final Set<TestWebSocketAction> connections = new CopyOnWriteArraySet<TestWebSocketAction>();

    private String nickName;

    /**
     * WebSocket Session
     */
    private Session session;

    public TestWebSocketAction() {
    }

    /**
     * 打开连接
     * 
     * @param session
     * @param nickName
     */
    @OnOpen
    public void onOpen(Session session,
            @PathParam(value = "nickName") String nickName) {

        this.session = session;
        this.nickName = nickName;

        connections.add(this);
        String message = String.format("System> %s %s", this.nickName,
                " has joined.");
        TestWebSocketAction.broadCast(message);
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose() {
        connections.remove(this);
        String message = String.format("System> %s, %s", this.nickName,
                " has disconnection.");
        TestWebSocketAction.broadCast(message);
    }

    /**
     * 接收信息
     * 
     * @param message
     * @param nickName
     */
    @OnMessage
    public void onMessage(String message,
            @PathParam(value = "nickName") String nickName) {
    	TestWebSocketAction.broadCast(nickName + ">" + message);
    }

    /**
     * 错误信息响应
     * 
     * @param throwable
     */
    @OnError
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    /**
     * 发送或广播信息
     * 
     * @param message
     */
    private static void broadCast(String message) {
        for (TestWebSocketAction chat : connections) {
            try {
                synchronized (chat) {
                    chat.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                connections.remove(chat);
                try {
                    chat.session.close();
                } catch (IOException e1) {
                }
                TestWebSocketAction.broadCast(String.format("System> %s %s", chat.nickName,
                        " has bean disconnection."));
            }
        }
    }
}
