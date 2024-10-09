package com.webest.user.domain.model;

import com.webest.app.jpa.BaseEntity;
import com.webest.user.domain.model.vo.UserDto;
import com.webest.user.presentation.dto.request.UserUpdateRequest;
import com.webest.web.common.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column( nullable = false, length = 50)
    private String userName;
    @Column( nullable = false, length = 50, unique = true)
    private String email;
    @Column( nullable = false, length = 50)
    private String phone;
    @Column(nullable = false)
    private UserRole role;
    private Integer addressCode;            // 주소 코드 번호
    private String city;                    // 시
    private String street;                  // 구
    private String district;                // 동


    // Auth -> Dto
    public UserDto to(){
        return new UserDto(
                this.id,
                this.userId,
                this.password,
                this.userName,
                this.email,
                this.phone,
                this.role,
                this.addressCode,
                this.city,
                this.street,
                this.district
        );
    }

    public void update(UserUpdateRequest request, Integer addressCode){
        this.password = request.password() !=null ? request.password() : this.password;
        this.userName = request.userName() !=null ? request.userName() : this.userName;
        this.email = request.email() !=null ? request.email() : this.email;
        this.phone = request.phone() !=null ? request.phone() : this.phone;
        this.addressCode = addressCode !=null ? addressCode : this.addressCode;
        this.city = request.city() !=null ? request.city() : this.city;
        this.street = request.street() !=null ? request.street() : this.street;
        this.district = request.district() !=null ? request.district() : this.district;
    }
}