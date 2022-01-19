package exercise;

//ArrayList 기능을 사용하기 위한 외부 패키지 import
import java.util.ArrayList;

public class AccountController {

	//멤버 변수
	private ArrayList<Account> listAccount;
	
	//기본 생성자
	public AccountController() {
		listAccount = new ArrayList<Account>();	//계정들을 담을 공간(List형) 생성
	}
	
	//계정 생성 메소드
	public boolean createAccount(Account inputAccount) {
		if ((inputAccount.getAccountID() != "") && (inputAccount.getAccountPassword() != "") && (inputAccount.getAccountName() != "")) {
			inputAccount.setAccountNumber(Integer.toString(listAccount.size() + 1));
			inputAccount.setAccountBalance(0);
			listAccount.add(inputAccount);
			return true;
		} else {
			return false;
		}
	}
	
	//계정 삭제 메소드
	public boolean removeAccount(String accountID, String accountPassword) {
		for(int i = 0; i < listAccount.size(); i++) {
			if((listAccount.get(i).getAccountID().equals(accountID)) && (listAccount.get(i).getAccountPassword().equals(accountPassword))) {
				listAccount.remove(i);
				return true;
			}
		}
		return false;
	}
	
	//계정 로그인 확인 메소드
	public boolean checkAccount(String accountID, String accountPassword) {
		for(int i = 0; i < listAccount.size(); i++) {
			if((listAccount.get(i).getAccountID().equals(accountID)) && (listAccount.get(i).getAccountPassword().equals(accountPassword))) {
				return true;
			}
		}
		return false;
	}
}
