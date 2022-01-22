package exercise;

public class GoodTreeBankMain {

	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		LoginController loginController = new LoginController(accountController);
		loginController.run();
	}
}
