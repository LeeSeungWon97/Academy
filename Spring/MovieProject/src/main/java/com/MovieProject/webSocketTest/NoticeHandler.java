package com.MovieProject.webSocketTest;

import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class NoticeHandler extends TextWebSocketHandler {

	private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("notice접속");
		sessionList.add(session);
		JsonObject sendData = new JsonObject();
		sendData.addProperty("type", "userConnect");
		sendData.addProperty("userid", session.getId());

		for (int i = 0; i < sessionList.size(); i++) {
			if (!sessionList.get(i).getId().equals(session.getId())) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(sendData)));
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("notice접속 해제");
		sessionList.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("보낸 메세지: " + message.getPayload());
		JsonObject msgData = new JsonObject();
		msgData.addProperty("type", "notice");
		msgData.addProperty("content", message.getPayload());

		for (WebSocketSession connectSession : sessionList) {
			connectSession.sendMessage(new TextMessage(new Gson().toJson(msgData)));
		}
	}

}
