package com.java.course.com.przykladyNowe;

public class BankAccount {
    private NewUserAccount user;
    private int numberAccount;
    private double monyOnAcount;

    private String historyOfTransaction;

    public BankAccount(NewUserAccount user, int numberAccount, double monyOnAcount, String historyOfTransaction) {
        this.user = user;
        this.numberAccount = numberAccount;
        this.monyOnAcount = monyOnAcount;
        this.historyOfTransaction = historyOfTransaction;
    }

   /* public static int BankAccountOperation(NewUserAccount user, int nameOperation, double money) {
        return Optional.ofNullable(user)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(sum -> sum )
    }

    */

    public int addOrMinusFromAccount(String addOrMinus, int money, int quantity) {
        if (addOrMinus.equals("add")) {
            money = money + quantity;
        } else if (addOrMinus.equals("subtract")) {
            money = money - quantity;
        }
        return money;
    }


    public NewUserAccount getUser() {
        return user;
    }

    public void setUser(NewUserAccount user) {
        this.user = user;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getMonyOnAcount() {
        return monyOnAcount;
    }

    public void setMonyOnAcount(double monyOnAcount) {
        this.monyOnAcount = monyOnAcount;
    }

    public String getHistoryOfTransaction() {
        return historyOfTransaction;
    }

    public void setHistoryOfTransaction(String historyOfTransaction) {
        this.historyOfTransaction = historyOfTransaction;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "user=" + user +
                ", numberAccount=" + numberAccount +
                ", monyOnAcount=" + monyOnAcount +
                ", historyOfTransaction='" + historyOfTransaction + '\'' +
                '}';
    }
}
