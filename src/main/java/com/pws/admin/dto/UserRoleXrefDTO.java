package com.pws.admin.dto;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Vinayak M
 * @Date 10/01/23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleXrefDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Boolean isActive;
}
