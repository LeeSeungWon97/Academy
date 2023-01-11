package com.MovieProject.webSocketTest;

import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ChatMessageHandler extends TextWebSocketHandler {

	private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {		
		System.out.println("웹소켓 - 채팅 페이지 접속");
		System.out.println("접속한 세션 ID: " + session.getId());
//		session.sendMessage(new TextMessage("채팅 페이지 접속!"));

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "notice");
		jsonObj.addProperty("msg", session.getId() + "가 접속 했습니다.");
		// 채팅 서버에 접속한 다른 클라이언트에게 접속 안내
		for (int i = 0; i < sessionList.size(); i++) {
			sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
		}
		sessionList.add(session);

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("페이지에서 보낸 메세지: " + message.getPayload());
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "chat");
		jsonObj.addProperty("sendId", session.getId());
		jsonObj.addProperty("msg", message.getPayload());

		for (int i = 0; i < sessionList.size(); i++) {
			if (session.getId() != sessionList.get(i).getId()) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("웹소켓 - 채팅 페이지 접속해제");
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "notice");
		jsonObj.addProperty("msg", session.getId() + "가 접속 해제했습니다.");
		sessionList.remove(session);
		for (int i = 0; i < sessionList.size(); i++) {
			if (session.getId() != sessionList.get(i).getId()) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
			}
		}
	}
}
