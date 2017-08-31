package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class UserMenu implements Serializable {
    private static final long serialVersionUID = -2730353417764302901L;

    private Long id;

    private String userAccount;

    private String menuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    @Override
    public String toString() {
        return "UserMenu{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", menuId='" + menuId + '\'' +
                '}';
    }
}