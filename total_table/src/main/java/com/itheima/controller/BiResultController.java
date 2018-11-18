package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.BiResult;
import com.itheima.service.BiResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class BiResultController {

    @Autowired
    private BiResultService biResultService;

    /**
     * 不分页查询所有
     * @return
     */
    @RequestMapping("/list")
    public List<BiResult> list(){
        return biResultService.list();
    }

    //搜索 不行
    @RequestMapping("/search")
    public List<BiResult> search(@RequestParam(value = "startTime",required = false) String startTime,@RequestParam(value = "endTime",required = false) String endTime){
        return biResultService.search(startTime,endTime);
    }


    /***
     * 分页查询数据
     * 获取JSON数据
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public PageInfo<BiResult> list(@RequestBody BiResult biResult, @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return biResultService.getAllPage(biResult,page, size);
    }
}
