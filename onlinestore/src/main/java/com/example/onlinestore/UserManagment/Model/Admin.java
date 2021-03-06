package com.example.onlinestore.UserManagment.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Admin extends User {
    @ManyToOne
    @JoinColumn(name = "addedBy", referencedColumnName = "username")
    private Admin addedBy;

    public Admin getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Admin addedBy) {
        this.addedBy = addedBy;
    }
}
