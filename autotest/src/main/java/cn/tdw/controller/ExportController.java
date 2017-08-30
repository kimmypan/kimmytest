package cn.tdw.controller;

import cn.tdw.common.exception.RRException;
import cn.tdw.common.utils.HttpContextUtils;
import cn.tdw.common.utils.excel.ExportExcel;
import cn.tdw.dto.AllocationDetailDTO;
import cn.tdw.dto.TraceDetailDTO;
import cn.tdw.dto.TraceDetailSearchDTO;
import cn.tdw.modules.sys.controller.AbstractController;
import cn.tdw.modules.sys.service.ShiroService;
import cn.tdw.service.CollectionTaskService;
import eu.bitwalker.useragentutils.Browser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

/**
 * Created by wuganqin on 2017/8/17.
 */
@Controller
@RequestMapping("/manager/export")
public class ExportController extends AbstractController{

    @Autowired
    private CollectionTaskService collectionTaskService;

    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "/traceDetails", method = RequestMethod.POST)
    public void exportTraceDetails(TraceDetailSearchDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = "项目跟踪详情列表";
        checkBrowser(request, response, fileName);
        List<TraceDetailDTO> details = collectionTaskService.queryTraceDetails(dto);
        ExportExcel exportExcel = new ExportExcel(fileName, TraceDetailDTO.class).setDataList(details);
        exportExcel.write(response.getOutputStream());
    }

    @RequestMapping(value = "/traceDetailsForOne", method = RequestMethod.POST)
    public void exportTraceDetailsForOne(TraceDetailSearchDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (dto==null){
            dto = new TraceDetailSearchDTO();
        }
        if (dto.getTrackerId() ==null){
            dto.setTrackerId(getUserId());
        }else {
            //判断用户是否有项目跟踪详情菜单的权限，以防用户修改sessionstorage
            Set<String> userPermissions = shiroService.getUserPermissions(getUserId());
            if (!userPermissions.contains("collection:itemDetails:list")){
                throw new RRException("您没有权限访问");
            }
        }
        String fileName = "跟踪人跟踪详情列表";
        checkBrowser(request, response, fileName);
        List<TraceDetailDTO> details = collectionTaskService.queryTraceDetails(dto);
        ExportExcel exportExcel = new ExportExcel(fileName, TraceDetailDTO.class).setDataList(details);
        exportExcel.write(response.getOutputStream());
    }


    @RequestMapping(value = "/allocationDetails", method = RequestMethod.POST)
    public void exportAllocationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = "电话催收分配-分配详情列表";
        checkBrowser(request, response, fileName);
        List<AllocationDetailDTO> details = collectionTaskService.queryAllocationDetails();
        ExportExcel exportExcel = new ExportExcel(fileName, AllocationDetailDTO.class).setDataList(details);
        exportExcel.write(response.getOutputStream());
    }

    private void checkBrowser(HttpServletRequest request, HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        String userAgent = HttpContextUtils.getBrowerInfo(request);
        if (StringUtils.isNotBlank(userAgent)) {
            userAgent = "-" + Browser.parseUserAgentString(userAgent).getName();
        }
        if (userAgent != null && userAgent.indexOf("Firefox") > -1) {
            // Firefox
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyMMdd_HHmmss")) + ".xls");
        } else {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8")
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("_yyMMdd_HHmmss")) + ".xls");
        }
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=utf-8");
    }


}
