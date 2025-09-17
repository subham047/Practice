package com.subham.Practice.Utilities;

public class JwtDataLogin {
    private String uniqueRefNumber;
    private String coinBalance;

    public JwtDataLogin(String uniqueRefNumber, String coinBalance) {
        this.uniqueRefNumber = uniqueRefNumber;
        this.coinBalance = coinBalance;
    }

    public JwtDataLogin() {
    }

    public String getUniqueRefNumber() {
        return uniqueRefNumber;
    }

    public void setUniqueRefNumber(String uniqueRefNumber) {
        this.uniqueRefNumber = uniqueRefNumber;
    }

    public String getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(String coinBalance) {
        this.coinBalance = coinBalance;
    }
}
