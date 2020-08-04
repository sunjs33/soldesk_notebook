package main.service;

import java.util.Collection;

import main.DTO.MemberDTO;
import main.DTO.memberDao;

public class MemberListPrinter {
	private memberDao memberDao=new memberDao();
	private MemberPrinter printer=new MemberPrinter();
	public void printAll() {
		Collection<MemberDTO> lists=memberDao.selectAll();
		System.out.println("총 회원수는 : "+lists.size());
		for (MemberDTO memberDTO : lists) {
			printer.print(memberDTO);
			
			
		}
		
	}
	

}
