package com.six2d.controller;

import com.six2d.entity.DsSection;
import com.six2d.entity.LayTree;
import com.six2d.service.DsSectionService;
import com.six2d.vo.MsgData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SectionController {
    Logger logger = LoggerFactory.getLogger(SectionController.class);

    @Autowired
    DsSectionService dsSectionService;

    @PostMapping("/section")
    @ResponseBody
    public MsgData setSectionById(@RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("parent") Integer pId) {
        DsSection dsSection = new DsSection();
        dsSection.setSection_id(id);
        dsSection.setSection_name(name);
        dsSection.setSection_pId(pId);

        logger.info("{} {} {}", id, name, pId);
        int row = dsSectionService.setDsSectionById(dsSection);

        logger.info("Affected rows:{}", row);
        if (row != 0) {
            return MsgData.SUCCESS;
        } else {
            return MsgData.FAIL;
        }
    }

    @GetMapping("/section/{id}")
    @ResponseBody
    public DsSection getSectionById(@PathVariable("id") Integer id) {
        return dsSectionService.getDsSectionById(id);
    }

    @GetMapping("/sections/{pId}")
    @ResponseBody
    public List<DsSection> getSectionByPid(@PathVariable("pId") Integer pId) {
        return dsSectionService.getDsSectionByPid(pId);
    }

    @GetMapping("/section")
    @ResponseBody
    public List<DsSection> getSection(){
        return dsSectionService.getDsSection();
    }

    @GetMapping("/section/formatted")
    @ResponseBody
    public List<LayTree> getSectionFormatted() {
        List sectionList = dsSectionService.getDsSection();

        Map<Integer, List<LayTree>> map = new HashMap<>();

        for (int i = 0; i < sectionList.size(); i++) {
            DsSection section = (DsSection) sectionList.get(i);

            LayTree l = new LayTree();
            l.setTitle(section.getSection_name());
            l.setId(section.getSection_id());
            l.setField(section.getSection_pId());

            List<LayTree> layTreeList = map.get(section.getSection_pId());
            if (layTreeList == null) {
                layTreeList = new ArrayList<>();
            }
            layTreeList.add(l);
            map.put(section.getSection_pId(), layTreeList);
        }

        for (Map.Entry<Integer, List<LayTree>> entry : map.entrySet()) {
            List<LayTree> layTreeList = entry.getValue();
            for (LayTree l : layTreeList) {
                logger.info(l.getTitle());
            }
        }

        List<LayTree> l = new ArrayList<>();
        l.add(any(map));
        return l;
    }

    private LayTree any(Map<Integer, List<LayTree>> layTreeMap) {
        LayTree layTree = new LayTree();
        for (Map.Entry<Integer, List<LayTree>> entry : layTreeMap.entrySet()) {
            Integer pId = entry.getKey();
            if (pId == 0) {
                layTree = entry.getValue().get(0);
                continue;
            }
            for (LayTree l : entry.getValue()) {
                LayTree temp = find(layTree, l.getField());
                if (temp != null) {
                    temp.getChildren().add(l);
                } else {
                    System.out.println("Exception!");
                }
            }
        }
        return layTree;
    }

    //寻找隶属关系
    private LayTree find(LayTree layTree, Integer pId) {
        if (layTree.getId() == pId)
            return layTree;
        List<LayTree> layTreeList = layTree.getChildren();
        for (int i = 0; i < layTreeList.size(); i++) {
            if (layTreeList.get(i).getId() == pId) {
                return layTreeList.get(i);
            } else {
                find(layTreeList.get(i), pId);
            }
        }
        return null;
    }
}
