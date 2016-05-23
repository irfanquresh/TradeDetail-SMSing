/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.trillit;

import java.util.Date;

/**
 *
 * @author IRFAN
 */
public class Trade {
    int id;
    int tradeSymbolNumber;
    String tradeSymboltext;
    int tradeMode;
    int tradeQuantity;
    double tradePrice;
    double tradeTotal;
    String tradePhone;
    String tradeUser;
    String tradeDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTradeSymbolNumber() {
        return tradeSymbolNumber;
    }

    public void setTradeSymbolNumber(int tradeSymbolNumber) {
        this.tradeSymbolNumber = tradeSymbolNumber;
    }

    public String getTradeSymboltext() {
        return tradeSymboltext;
    }

    public void setTradeSymboltext(String tradeSymboltext) {
        this.tradeSymboltext = tradeSymboltext;
    }

    public int getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(int tradeMode) {
        this.tradeMode = tradeMode;
    }

    public int getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(int tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public double getTradeTotal() {
        return tradeTotal;
    }

    public void setTradeTotal(double tradeTotal) {
        this.tradeTotal = tradeTotal;
    }

    public String getTradePhone() {
        return tradePhone;
    }

    public void setTradePhone(String tradePhone) {
        this.tradePhone = tradePhone;
    }

    public String getTradeUser() {
        return tradeUser;
    }

    public void setTradeUser(String tradeUser) {
        this.tradeUser = tradeUser;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

}
