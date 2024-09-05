package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String NAME;     // 이름
    private String ID;       // 아이디(이메일) / UNIQUE, 중복 방지
    private String PASSWORD; // 비밀번호 길이 20자 제한
    private String NUMBER;   // 전화번호

    public String getEmail() {
        return ID;
    }
/*
    @Override
    public String toString() {
        return "User{username='" + NAME + "', ID='" + ID + "'}";
    }*/
}
