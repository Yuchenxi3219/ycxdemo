package com.example.demo.vo;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author YuChenXi
 * @date 2022/3/9 10:17 下午
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    @Max(value = 10000, message = "Id cannot be greater than 10000")
    private Integer id;
    @NotNull(message = "name cannot be null")
    private String name;
}
