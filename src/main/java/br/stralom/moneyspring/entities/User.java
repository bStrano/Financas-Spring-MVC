/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 2L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotNull
    private String user_name;
    @NotNull
    private String user_lastName;
    @NotNull
    private String user_password;
    @NotNull
    private String user_email;
    @OneToMany(mappedBy = "bal_user")
    private Set<Balance> user_balances = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="tb_user_role",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_name")})
    private List<Role> user_roles = new ArrayList<>();
    @OneToMany(mappedBy = "cat_user", cascade = CascadeType.ALL)
    private List<Category> user_categories = new ArrayList<>();
    @OneToMany(mappedBy = "com_user", cascade = CascadeType.ALL)
    private Collection<Company> user_companies = new ArrayList<>();
    
    public User() {
    }


    
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_lastName() {
        return user_lastName;
    }

    public void setUser_lastName(String user_lastName) {
        this.user_lastName = user_lastName;
    }



    public Set<Balance> getUser_balances() {
        return user_balances;
    }

    public void setUser_balances(Set<Balance> user_balances) {
        this.user_balances = user_balances;
    }

    public List<Role> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<Role> user_roles) {
        this.user_roles = user_roles;
    }

    public List<Category> getUser_categories() {
        return user_categories;
    }

    public void setUser_categories(List<Category> user_categories) {
        this.user_categories = user_categories;
    }

    public Collection<Company> getUser_companies() {
        return user_companies;
    }

    public void setUser_companies(Collection<Company> user_companies) {
        this.user_companies = user_companies;
    }
        
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.user_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.user_email, other.user_email)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }

   

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user_roles;
    }

    @Override
    public String getPassword() {
        return this.user_password;
    }

    @Override
    public String getUsername() {
        return this.user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    

    
    
    
}
