/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class accountUser {

    private String account;
    private String password;
    private String roleID;
    private String status;

    public accountUser(String account, String password, String roleID, String status) {
        this.account = account;
        this.password = password;
        this.roleID = roleID;
        this.status = status;
    }

    public accountUser(String account, String roleID) {
        this.account = account;
        this.roleID = roleID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
