package day15;

public class BankInfo {

  private String accountNumber; // 계좌번호
  private String clientName; // 고객이름
  private int balance; // 잔액

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "[ 계좌번호 ] " + accountNumber + "\n[ 고객이름 ]" + clientName + "\n[ 잔액 ]" + balance;
  }

}
