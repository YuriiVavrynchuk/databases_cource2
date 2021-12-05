package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimatorDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private String character;
    private Integer salary;
    private Integer experience;
    private String phone;
    private String email;
}
