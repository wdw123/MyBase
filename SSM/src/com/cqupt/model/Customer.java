package com.cqupt.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Repository
@ToString
public class Customer {

    @NotNull
    private Integer custId;

    //length>0
    @NotBlank
    private String custName;

    //职业
    @NotBlank
    private String custProfession;

    @Length(max = 11, min = 11)
    @NotBlank
    private String custPhone;

    @Email
    @NotBlank
    private String email;

}
