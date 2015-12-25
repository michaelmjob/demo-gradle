package com.shawn.demo.controller;

import com.shawn.demo.commons.Page;
import com.shawn.demo.model.Dict;
import com.shawn.demo.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
@RestController
@RequestMapping("/dict")
public class DictController {
    @Autowired
    IDictService service;

    @RequestMapping(value = "/list.do")
    Page<Dict> getDictList(@RequestBody(required = false) Map<String, Object> params) {
        Page<Dict> dictList = service.findDicts(params);
        return dictList;
    }
}
