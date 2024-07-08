package com.ohgiraffers.section02.reflection;

public class Account {
    private String bankCode;    // 은행코드
    private String accNo;       // 계좌번호
    private String accPwd;      // 비밀번호
    private int balance;        // 잔액

    public Account() {}

    public Account(String bankCode, String accNo, String accPwd) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this(bankCode, accNo, accPwd);
        this.balance = balance;
    }

    // 현재 잔액 출력
    public String getBalance(){
        return this.accNo + " 계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    // 금액을 parameter로 받아 입금
    public String deposit(int money){
        String str = "";
        if (money >= 0){
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }
        return str;
    }

    // 금액을 parameter로 받아 출금
    public String withdraw(int money){
        String str = "";
        if (this.balance >= money){
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요.";
        }
        return str;
    }
}
