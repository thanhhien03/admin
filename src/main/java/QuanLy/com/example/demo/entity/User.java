package QuanLy.com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.usertype.UserType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name =  "id")
    private Long id;
    @Column(name =  "username")
    private String username;
    @Column(name =  "password")
    private String password;
    @Column(name =  "email")
    private String email;
    @Column(name =  "address")
    private String address;
    @Column(name =  "phoneNumber")
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public void login(String username, String password) {
        // Kiểm tra xác thực đăng nhập
        if (authenticate(username, password)) {
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Đăng nhập thất bại");
        }
    }

    private boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }

    public void managePersonalAccount(String newPassword) {
        // Cập nhật mật khẩu mới cho tài khoản cá nhân
        updatePassword(newPassword);
        System.out.println("Cập nhật mật khẩu thành công");
    }

    private void updatePassword(String newPassword) {
        System.out.println("Mật khẩu đã được cập nhật thành công");
    }

}
