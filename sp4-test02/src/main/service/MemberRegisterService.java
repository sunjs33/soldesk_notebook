package main.service;

import java.util.Date;

import main.DTO.MemberDTO;
import main.DTO.RegisterRequest;
import main.DTO.memberDao;

public class MemberRegisterService {
	private memberDao memberDao=new memberDao();
	
	public void regist(RegisterRequest req) {
		MemberDTO dto=memberDao.selectByEmail(req.getEmail());
		if(dto==null) {
			dto=new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료되었습니다.");
		}else {
			System.out.println("중복 사용자 입니다.");
		}
		
	}

}
