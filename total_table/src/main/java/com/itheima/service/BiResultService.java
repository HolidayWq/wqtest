package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.BiResult;

import java.util.List;

public interface BiResultService {
    //查询所有,不分页
    List<BiResult> list();

    //搜索,不分页
    List<BiResult> search(String startTime, String endTime);

    //分页查询
    PageInfo<BiResult> getAllPage(BiResult biResult, int page, int size);
}
