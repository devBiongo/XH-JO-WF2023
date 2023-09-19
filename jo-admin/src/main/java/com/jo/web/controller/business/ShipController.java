package com.jo.web.controller.business;

import com.jo.business.domain.dto.*;
import com.jo.business.domain.po.*;
import com.jo.business.service.*;
import com.jo.common.core.domain.AjaxResult;
import com.jo.common.core.model.SearchModel;
import com.jo.common.utils.bean.ModelUtil;
import com.jo.web.param.ShipParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Joffrey
 * @since 2023-08-29
 */
@RestController
@RequestMapping("/shipDoc")
public class ShipController {

    @Autowired
    IShipDocService masterShipDocService;

    @Autowired
    IAssignmentService assignmentService;

    @Autowired
    IContainerService containerService;

    @Autowired
    IConsignService consignService;

    @Autowired
    INotifierService notifierService;

    @PostMapping("/fetchMasterShipDocs")
    public AjaxResult fetchMasterShipDocs(@RequestBody SearchModel<ShipDocPo> searchModel) {
        return AjaxResult.success(masterShipDocService.list(searchModel.getQueryModel()));
    }

    @PostMapping("/registerNewShipDoc")
    @Transactional
    public void registerNewShipDoc(@RequestBody Map<String, String> map) {
        ShipDocPo masterShipDoc = new ShipDocPo();
        masterShipDoc.setIoType(map.get("ioType"));
        masterShipDoc.setInvoiceNo(map.get("invoiceNo"));
        masterShipDocService.save(masterShipDoc);
        // dtlAssignment
        AssignPo dtlAssignment = new AssignPo();
        dtlAssignment.setShipDocId(masterShipDoc.getShipDocId());
        assignmentService.save(dtlAssignment);
        // dtlContainer
        ContainerPo dtlContainer = new ContainerPo();
        dtlContainer.setShipDocId(masterShipDoc.getShipDocId());
        containerService.save(dtlContainer);
        // dtlConsign
        ConsignPo dtlConsign = new ConsignPo();
        dtlConsign.setShipDocId(masterShipDoc.getShipDocId());
        consignService.save(dtlConsign);
        // dtlNotifier
        NotifierPo dtlNotifier = new NotifierPo();
        dtlNotifier.setShipDocId(masterShipDoc.getShipDocId());
        notifierService.save(dtlNotifier);
    }

    @PostMapping("/updateShipDoc")
    @Transactional
    public void updateShipDoc(@RequestBody ShipParam shipParam) {
        shipParam.setUpShipDocId();
        masterShipDocService.updateShipDoc(shipParam.getShipDocDto());
        assignmentService.updateAssignments(shipParam.getAssignDtoList());
        consignService.updateConsigns(shipParam.getConsignDtoList());
        containerService.updateContainers(shipParam.getContainerDtoList());
        notifierService.updateNotifiers(shipParam.getNotifierDtoList());
    }

    @GetMapping("/fetchShipDocById")
    public AjaxResult fetchShipDocById(@RequestParam(value = "shipDocId", required = true) String shipDocId) {
        HashMap<Object, Object> hashMap = new HashMap<>() {{
            put("shipDoc", ModelUtil.convertDtoPo(masterShipDocService.getById(shipDocId), ShipDocDto.class));
            put("assignList", ModelUtil.convertDtoPoBatch(assignmentService.selectList(shipDocId), AssignDto.class));
            put("consignList", ModelUtil.convertDtoPoBatch(consignService.selectList(shipDocId), ConsignDto.class));
            put("containerList", ModelUtil.convertDtoPoBatch(containerService.selectList(shipDocId), ContainerDto.class));
            put("notifierList", ModelUtil.convertDtoPoBatch(notifierService.selectList(shipDocId), NotifierDto.class));
        }};
        return AjaxResult.success(hashMap);
    }
}