package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "role",schema = "house_management")
public class Role implements GrantedAuthority {

    @Id
    private Long id;

    @Column(name = "authority")
    private String authority;

    @Override
    public String getAuthority(){
        return authority;
    }
}
