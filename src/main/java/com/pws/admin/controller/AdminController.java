package com.pws.admin.controller;

import com.pws.admin.dto.PermissionDTO;
import com.pws.admin.dto.SignUpDTO;
import com.pws.admin.dto.UserRoleXrefDTO;
import com.pws.admin.ApiSuccess;
import com.pws.admin.entity.Module;
import com.pws.admin.entity.Permission;
import com.pws.admin.entity.Role;
import com.pws.admin.entity.User;
import com.pws.admin.entity.UserRoleXref;
import com.pws.admin.exception.config.PWSException;
import com.pws.admin.service.AdminService;
import com.pws.admin.utility.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author Vinayak M
 * @Date 09/01/23
 */

@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("public/signup")
    public ResponseEntity<Object> signup(@RequestBody SignUpDTO signUpDTO) throws PWSException {
        adminService.UserSignUp(signUpDTO);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.CREATED));
    }


    @PostMapping("private/add/role")
    public ResponseEntity<Object> addRole(@RequestBody Role role) throws PWSException {
        adminService.addRole(role);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }

    @PutMapping ("private/update/role")
    public ResponseEntity<Object> updateRole(@RequestBody Role role) throws PWSException {
        adminService.addRole(role);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }

    @GetMapping ("private/fetch/role/by/id")
    public ResponseEntity<Object> fetchRoleById( @RequestParam Integer id) throws PWSException {
        Optional<Role> role = adminService.fetchRoleById(id);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, role.get()));
    }

    @GetMapping("private/fetch/all/role")
    public ResponseEntity<Object> fetchAllRole() throws PWSException {
        List<Role> roleList = adminService.fetchAllRole();
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, roleList));
    }

    @PostMapping("private/role/activate/deactivate")
    public ResponseEntity<Object> deactivateOrActivateRoleById(@RequestParam Integer id, @RequestParam Boolean flag) throws PWSException {
        adminService.deactivateOrActivateRoleById(id, flag);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @PostMapping("private/add/module")
    public ResponseEntity<Object> addModule(@RequestBody Module module) throws PWSException {
        adminService.addModule(module);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @GetMapping("private/fetch/all/module")
    public ResponseEntity<Object> fetchAllModule() throws PWSException {
        List<Module> moduleli = adminService.fetchAllModule();
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, moduleli));
    }
    @GetMapping ("private/fetch/module/by/id")
    public ResponseEntity<Object> fetchModuleById( @RequestParam Integer id) throws PWSException {
        Optional<Module> moduleid = adminService.fetchModuleById(id);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, moduleid.get()));
   }
    @PutMapping ("private/update/module/deactivateOrActivateModuleById")
    public ResponseEntity<Object> deactivateOrActivateModuleById(@RequestParam Integer id,Boolean flag) throws PWSException {
        adminService.deactivateOrActivateModuleById(id,flag);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
   }
    @PutMapping("private/userxrefrole/save")
    public ResponseEntity<Object> saveOrUpdateUserXref(@RequestBody UserRoleXrefDTO userRoleXrefDTO) throws PWSException {
        adminService.saveOrUpdateUserXref(userRoleXrefDTO);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @PutMapping ("private/userxrefrole/deactivateOrActivateAssignedRoleToUser")
    public ResponseEntity<Object> deactivateOrActivateAssignedRoleToUser(@RequestParam Integer id,Boolean flag) throws PWSException {
        adminService.deactivateOrActivateAssignedRoleToUser(id,flag);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @GetMapping ("private/fetch/users/by/role_id")
    public ResponseEntity<Object> fetchUserByRole( @RequestParam Integer roleId) throws PWSException {
    	List<User> user =adminService.fetchUserByRole(roleId);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK,user));
    }
    @GetMapping("private/fetch/userxref/by/id")
    public ResponseEntity<Object>fetchUsersXrefByd(@RequestParam Integer id)throws Exception{
		Optional<UserRoleXref> optuserref=adminService.fetchUsersXrefByd(id);
		return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, optuserref.get()));
	}
    
    @PostMapping("private/add/permission")
    public ResponseEntity<Object>addPermission(@RequestBody PermissionDTO permissionDTO) throws PWSException {
        adminService.addPermission(permissionDTO);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @PutMapping ("private/update/permission")
    public ResponseEntity<Object> updatePermission(@RequestBody PermissionDTO permissionDTO) throws PWSException {
        adminService.updatePermission(permissionDTO);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    @GetMapping("private/fetch/all/permission")
    public ResponseEntity<Object> fetchAllPermission() throws PWSException {
        List<Permission> permli = adminService.fetchAllPermission();
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK,permli));
    }
    @GetMapping ("private/fetch/permission/by/id")
    public ResponseEntity<Object> fetchPermissionById( @RequestParam Integer id) throws PWSException {
        Optional<Permission> permid = adminService.fetchPermissionById(id);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, permid.get()));
    }
    @PutMapping ("private/permission/activate/deactivate")
    public ResponseEntity<Object> deactivateOrActivatePermissionById(@RequestParam Integer id, Boolean flag) throws PWSException {
        adminService.deactivateOrActivatePermissionById(id,flag);
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK));
    }
    
   
  
}
