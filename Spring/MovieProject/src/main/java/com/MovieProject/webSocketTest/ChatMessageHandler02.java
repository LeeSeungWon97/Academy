package com.MovieProject.webSocketTest;

import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.MovieProject.dto.MemberDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ChatMessageHandler02 extends TextWebSocketHandler {

	private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("채팅테스트02 접속");
		System.out.println("접속Session: " + session.getId());
		sessionList.add(session);

		MemberDto loginInfo = (MemberDto) session.getAttributes().get("loginInfo");
		String loginId = session.getId();
		if (loginInfo != null) {
			loginId = loginInfo.getMid();
		}

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "connectUser");
		jsonObj.addProperty("userid", loginId);
		jsonObj.addProperty("sending", " 님이 입장했습니다.");

		for (int i = 0; i < sessionList.size(); i++) {
			if (!sessionList.get(i).getId().equals(session.getId())) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
			}
		}

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("페이지에서 보낸 메세지: " + message.getPayload());
		
		MemberDto loginInfo = (MemberDto) session.getAttributes().get("loginInfo");
		String loginId = session.getId();
		if (loginInfo != null) {
			loginId = loginInfo.getMid();
		}
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "chat");
		jsonObj.addProperty("sendId", loginId);
		jsonObj.addProperty("msg", message.getPayload());

		for (int i = 0; i < sessionList.size(); i++) {
			if (session.getId() != sessionList.get(i).getId()) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("채팅테스트02 접속해제");
		System.out.println("접속해제Session: " + session.getId());
		sessionList.remove(session);

		MemberDto loginInfo = (MemberDto) session.getAttributes().get("loginInfo");
		String loginId = session.getId();
		if (loginInfo != null) {
			loginId = loginInfo.getMid();
		}

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("type", "disconnectUser");
		jsonObj.addProperty("userid", loginId);
		jsonObj.addProperty("sending", " 님이 퇴장했습니다.");

		for (int i = 0; i < sessionList.size(); i++) {
			if (!sessionList.get(i).getId().equals(session.getId())) {
				sessionList.get(i).sendMessage(new TextMessage(new Gson().toJson(jsonObj)));
			}
		}

	}

}
