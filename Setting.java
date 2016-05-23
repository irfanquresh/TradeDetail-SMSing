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
public class Setting {

    int id;
    String userName;

    String senderId;
    String password;
    int nseCursorPosition;
    int bseCursorPosition;
    String nseSyncDate;
    String bseSyncDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNseSyncDate() {
        return nseSyncDate;
    }

    public void setNseSyncDate(String nseSyncDate) {
        this.nseSyncDate = nseSyncDate;
    }

    public String getBseSyncDate() {
        return bseSyncDate;
    }

    public void setBseSyncDate(String bseSyncDate) {
        this.bseSyncDate = bseSyncDate;
    }


    public int getNseCursorPosition() {
        return nseCursorPosition;
    }

    public void setNseCursorPosition(int nseCursorPosition) {
        this.nseCursorPosition = nseCursorPosition;
    }

    public int getBseCursorPosition() {
        return bseCursorPosition;
    }

    public void setBseCursorPosition(int bseCursorPosition) {
        this.bseCursorPosition = bseCursorPosition;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
