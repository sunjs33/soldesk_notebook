package main.service;

import main.DTO.MemberDTO;
import main.DTO.memberDao;

public class ChangePasswordService {
	private memberDao memberDao=new memberDao();
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		MemberDTO dto=memberDao.selectByEmail(email);
		if (dto==null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPwd, newPwd);
		memberDao.update(dto);
		
	}

}
