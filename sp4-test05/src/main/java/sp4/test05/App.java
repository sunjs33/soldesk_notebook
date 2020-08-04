package sp4.test05;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import main.DTO.RegisterRequest;

public class App 
{
	private static GenericXmlApplicationContext ctx;
    public static void main( String[] args ) {
    	ctx=new GenericXmlApplicationContext("classpath:appCtx.xml");
    	Scanner sc=new Scanner(System.in);
    	while (true) {
			System.out.println("명령어를 입력하세요 ");
			String command=sc.nextLine();
			if (command.startsWith("new ")) {
				String [] arg=command.split(" ");
				if(arg.length!=5) {
					printHelp();
					continue;
				}
				RegisterRequest req=new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl=req.isPasswordEqualConfirmPassword();
				if(!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				MemberRegisterService mrs=ctx.getBean("memberRegisterService",MemberRegisterService.class)
				
			}
		}
    	
    	
    }
    public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료는 exit");

	}
}
