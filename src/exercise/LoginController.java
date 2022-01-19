package exercise;

//사용자 입력 받기
import java.util.Scanner;

public class LoginController {

	// 멤버 변수
	private AccountController accountController;
	private final static String PROMPT = "select> "; // 프롬프트 구문 출력
	Scanner scanner = new Scanner(System.in);

	// 기본 생성자
	public LoginController(AccountController input) {
		accountController = input;
	}

	// 메인 메뉴 실행 메소드
	public void run() {
		int ui_id = 0;
		boolean exit = true;
		while (exit) {
			System.out.println("1. 로그인");
			System.out.println("2. 계정 생성");
			System.out.print(PROMPT);
			ui_id = scanner.nextInt();
			if (ui_id == 1) {
				if (processLogin()) {
					exit = false;
				} else if (ui_id == 2) {
					processCreateAccount();
				}
			}
			scanner.close();
		}
	}

	// 로그인 화면 메소드
	public boolean processLogin() {

		boolean exit = true;
		while (exit) {
			System.out.println("ID : ");
			System.out.print(PROMPT);
			String strAccountID = scanner.next();
			System.out.println("Password : ");
			System.out.print(PROMPT);
			String strAccountPassword = scanner.next();
			if (accountController.checkAccount(strAccountID, strAccountPassword)) {
				System.out.println("로그인에 성공하였습니다!!");
				exit = false;
			} else {
				System.out.println("ID와 Password가 불일치합니다!!");
			}
		}
		return true;
	}

	// 계정 생성 메소드
	public boolean processCreateAccount() {

		boolean exit = true;
		while (exit) {
			System.out.println("새 계좌 명의 : ");
			System.out.print(PROMPT);
			String strAccountName = scanner.next();
			System.out.println("새 계좌 ID : ");
			System.out.print(PROMPT);
			String strAccountID = scanner.next();
			System.out.println("새 계좌 암호 : ");
			System.out.print(PROMPT);
			String strAccountPassword = scanner.next();

			Account inputAccount = new Account();
			inputAccount.setAccountName(strAccountName);
			inputAccount.setAccountID(strAccountID);
			inputAccount.setAccountPassword(strAccountPassword);
			if (accountController.createAccount(inputAccount)) {
				System.out.println("계좌 생성에 성공하였습니다.");
				exit = false;
			}
		}
		return true;
	}
}