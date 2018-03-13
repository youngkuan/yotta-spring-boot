package com.xjtu.facet.controller;

import com.xjtu.common.domain.Result;
import com.xjtu.common.domain.ResultEnum;
import com.xjtu.facet.service.FacetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * api: 处理facet分面
 * @author yangkuan
 * @date 2018/3/12 15:34
 */
@RestController
@RequestMapping("/facet")
public class FacetController {

    @Autowired
    private FacetService facetService;

    @ApiOperation(value = "在指定的课程和主题下添加一级分面", notes = "在指定的课程和主题下添加一级分面")
    @GetMapping("/insertFirstLayerFacet")
    public ResponseEntity insertFirstLayerFacet(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName
            , @RequestParam(name = "facetName") String facetName){
        Result result = facetService.insertFacetByDomainAndTopic(domainName, topicName, facetName, 1);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "在指定的课程和主题下添加二级分面", notes = "在指定的课程和主题下添加二级分面")
    @GetMapping("/insertSecondLayerFacet")
    public ResponseEntity insertSecondLayerFacet(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName
            , @RequestParam(name = "facetName") String facetName){
        Result result = facetService.insertFacetByDomainAndTopic(domainName, topicName, facetName, 2);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "获得主题的所有分面信息", notes = "输入课程名和主题名，获得知识主题的所有分面信息，知识森林VR使用（吴科炜）")
    @GetMapping("/getFacetsByDomainNameAndTopicName")
    public ResponseEntity getFacetsByDomainNameAndTopicName(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName){
        Result result = facetService.findFacetsByDomainNameAndTopicName(domainName, topicName);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "获得指定课程、主题和一级分面下的二级分面数", notes = "获得指定课程、主题和一级分面下的二级分面数")
    @GetMapping("/getSecondLayerFacetNumber")
    public ResponseEntity getSecondLayerFacetNumber(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName
            , @RequestParam(name = "firstLayerFacetName") String firstLayerFacetName){
        Result result = facetService.findSecondLayerFacetNumber(domainName, topicName, firstLayerFacetName);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "获得指定课程、主题和二级分面下的三级分面数", notes = "获得指定课程、主题和二级分面下的三级分面数")
    @GetMapping("/getThirdLayerFacetNumber")
    public ResponseEntity getThirdLayerFacetNumber(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName
            , @RequestParam(name = "secondLayerFacetName") String secondLayerFacetName){
        Result result = facetService.findThirdLayerFacetNumber(domainName, topicName, secondLayerFacetName);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @ApiOperation(value = "指定课程、主题，获得所有一级分面下的二级分面信息", notes = "指定课程、主题，获得所有一级分面下的二级分面信息")
    @GetMapping("/getSecondLayerFacetGroupByFirstLayerFacet")
    public ResponseEntity getSecondLayerFacetGroupByFirstLayerFacet(@RequestParam(name = "domainName") String domainName
            , @RequestParam(name = "topicName") String topicName){
        Result result = facetService.findSecondLayerFacetGroupByFirstLayerFacet(domainName, topicName);
        if (!result.getCode().equals(ResultEnum.SUCCESS.getCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }




}
