package com.MovieProject.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MovieProject.dao.MemberDao;
import com.MovieProject.dto.MemberDto;

@Service
public class MemberService {

	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private ServletContext context;
	
	public int memberJoin(MemberDto joinInfo) throws IllegalStateException, IOException{
		System.out.println("MemberService memberJoin 호출");

		// 첨부파일 처리(첨부파일에서 파일명 추출)
		String mfilename = ""; // 첨부파일명 저장 변수
		MultipartFile mfile = joinInfo.getMfile();
		
		// 1. 첨부파일 유무 확인
		if(mfile.isEmpty()) {
			System.out.println("첨부파일 없음");
		} else {
			System.out.println("첨부파일 있음");
			
			// 2. 파일명 처리
			UUID uuid = UUID.randomUUID(); // 32자리의 랜덤 코드
			mfilename = uuid.toString() + "_" + mfile.getOriginalFilename();
			
			// 3. 파일 저장 memberProfileUpload (src > main > webapp > resources > 폴더 생성)
			// 3-1. 파일 저장 경로 설정
			String savePath = context.getRealPath("resources/memberProfileUpload");
			System.out.println("savePath: " + savePath);
			// 3-2 파일 저장.
			File file = new File(savePath,mfilename); //savePath경로에 mfilename으로 빈 파일을 만들어 줌.
			mfile.transferTo(file); // 빈 파일(file)에 mfile을 덮어쓰기
		}
		System.out.println("첨부파일명: " + mfilename);
		
		joinInfo.setMprofile(mfilename);
		System.out.println(joinInfo);
		
		int insertResult = mdao.insertMemberJoin(joinInfo);
		return insertResult;
	}

	public MemberDto memberLogin(MemberDto loginId) {
		System.out.println("MemberService memberLogin 호출");
		MemberDto loginInfo = new MemberDto();
		
		try {
			loginInfo = mdao.selectLogin(loginId);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginInfo;
	}
	

}
