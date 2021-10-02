package com.example.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDto {

    private int userId;
    private String name;
    private int companyId;

}
