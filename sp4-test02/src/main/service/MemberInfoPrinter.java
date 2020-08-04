package main.service;

import main.DTO.MemberDTO;
import main.DTO.memberDao;

public class MemberInfoPrinter {
	private memberDao memberDao=new memberDao();
	private MemberPrinter printer=new MemberPrinter();
	public void printMemberInfo(String email) {
		MemberDTO dto=memberDao.selectByEmail(email);
		if(dto==null) {
			System.out.println("데이터 없음");
			return;
		}
		printer.print(dto);
		
		
	}

}
