package com.pws.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDTO {
	private Integer id;
	private Integer  modelid;
	private Integer roleId;
	private Boolean isActive;
	private Boolean isView;
	private Boolean isAdd;
	private Boolean isUpdate;
	private Boolean isDelete;
}
