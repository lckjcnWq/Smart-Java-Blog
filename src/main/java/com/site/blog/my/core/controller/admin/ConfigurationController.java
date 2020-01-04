package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.ConfigService;
import com.site.blog.my.core.util.Result;
import com.site.blog.my.core.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@Api(value = "配置操作")
@RequestMapping("/admin")
public class ConfigurationController {

    @Resource
    private ConfigService configService;

    @ApiOperation(value = "配置", notes = "跳到配置界面")
    @GetMapping("/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "admin/configuration";
    }


    @ApiOperation(value = "站点配置", notes = "跳到站点配置界面")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "websiteName",dataType = "String",value = "站点名称",paramType = "query",required = true),
                    @ApiImplicitParam(name = "websiteDescription",dataType = "String",value = "站点描述",paramType = "query",required = true),
                    @ApiImplicitParam(name = "websiteLogo",dataType = "String",value = "站点logo",paramType = "query",required = true),
                    @ApiImplicitParam(name = "websiteIcon",dataType = "String",value = "站点图片",paramType = "query",required = true)
            }
    )
    @PostMapping("/configurations/website")
    @ResponseBody
    public Result website(@RequestParam(value = "websiteName", required = false) String websiteName,
                          @RequestParam(value = "websiteDescription", required = false) String websiteDescription,
                          @RequestParam(value = "websiteLogo", required = false) String websiteLogo,
                          @RequestParam(value = "websiteIcon", required = false) String websiteIcon) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(websiteName)) {
            updateResult += configService.updateConfig("websiteName", websiteName);
        }
        if (!StringUtils.isEmpty(websiteDescription)) {
            updateResult += configService.updateConfig("websiteDescription", websiteDescription);
        }
        if (!StringUtils.isEmpty(websiteLogo)) {
            updateResult += configService.updateConfig("websiteLogo", websiteLogo);
        }
        if (!StringUtils.isEmpty(websiteIcon)) {
            updateResult += configService.updateConfig("websiteIcon", websiteIcon);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }


    @ApiOperation(value = "个人信息配置", notes = "跳到个人信息配置界面")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "yourAvatar",dataType = "String",value = "个人头像",paramType = "query",required = true),
                    @ApiImplicitParam(name = "yourName",dataType = "String",value = "个人名称",paramType = "query",required = true),
                    @ApiImplicitParam(name = "yourEmail",dataType = "String",value = "个人邮箱",paramType = "query",required = true)
            }
    )
    @PostMapping("/configurations/userInfo")
    @ResponseBody
    public Result userInfo(@RequestParam(value = "yourAvatar", required = false) String yourAvatar,
                           @RequestParam(value = "yourName", required = false) String yourName,
                           @RequestParam(value = "yourEmail", required = false) String yourEmail) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(yourAvatar)) {
            updateResult += configService.updateConfig("yourAvatar", yourAvatar);
        }
        if (!StringUtils.isEmpty(yourName)) {
            updateResult += configService.updateConfig("yourName", yourName);
        }
        if (!StringUtils.isEmpty(yourEmail)) {
            updateResult += configService.updateConfig("yourEmail", yourEmail);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }


    @ApiOperation(value = "底部设置", notes = "跳到个人信息配置界面")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "footerAbout",dataType = "String",value = "底部about",paramType = "query",required = true),
                    @ApiImplicitParam(name = "footerICP",dataType = "String",value = "底部ICP",paramType = "query",required = true),
                    @ApiImplicitParam(name = "footerCopyRight",dataType = "String",value = "底部CopyRight",paramType = "query",required = true),
                    @ApiImplicitParam(name = "footerPoweredBy",dataType = "String",value = "底部PoweredBy",paramType = "query",required = true),
                    @ApiImplicitParam(name = "footerPoweredByURL",dataType = "String",value = "底部ByURL",paramType = "query",required = true)
            }
    )
    @PostMapping("/configurations/footer")
    @ResponseBody
    public Result footer(@RequestParam(value = "footerAbout", required = false) String footerAbout,
                         @RequestParam(value = "footerICP", required = false) String footerICP,
                         @RequestParam(value = "footerCopyRight", required = false) String footerCopyRight,
                         @RequestParam(value = "footerPoweredBy", required = false) String footerPoweredBy,
                         @RequestParam(value = "footerPoweredByURL", required = false) String footerPoweredByURL) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(footerAbout)) {
            updateResult += configService.updateConfig("footerAbout", footerAbout);
        }
        if (!StringUtils.isEmpty(footerICP)) {
            updateResult += configService.updateConfig("footerICP", footerICP);
        }
        if (!StringUtils.isEmpty(footerCopyRight)) {
            updateResult += configService.updateConfig("footerCopyRight", footerCopyRight);
        }
        if (!StringUtils.isEmpty(footerPoweredBy)) {
            updateResult += configService.updateConfig("footerPoweredBy", footerPoweredBy);
        }
        if (!StringUtils.isEmpty(footerPoweredByURL)) {
            updateResult += configService.updateConfig("footerPoweredByURL", footerPoweredByURL);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }
}
