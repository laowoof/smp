package com.oceansoft.szga.smp.szsh.core.controller.system;

import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.common.controller.CrudController;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.FindRoleDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleAddDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleUpdateDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import com.oceansoft.szga.smp.szsh.core.service.system.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 * @author wx
 * @version 2018/9/19
 */
@RestController
@RequestMapping(value = {"/system/role"})
@Api(tags = {"角色管理"})
public class RoleController implements CrudController<SysRole,RoleAddDTO,RoleUpdateDTO,String,FindRoleDTO,SysRoleService> {

    private final SysRoleService sysRoleService;

    @Autowired
    public RoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Override
    public SysRoleService getService() {
        return sysRoleService;
    }


    @PostMapping(value = {"/newList"})
    @ApiOperation(value = "分页获取角色列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult getOrgListPage(@RequestBody @Validated @ApiParam(value = "搜索参数") FindRoleDTO findRoleDTO){
        return ResponseResult.e(ResponseCode.OK,sysRoleService.getRoleListPage(findRoleDTO));
    }

}
