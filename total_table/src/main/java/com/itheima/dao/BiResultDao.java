package com.itheima.dao;

import com.itheima.domain.BiResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BiResultDao extends JpaRepository<BiResult,Integer> {

    //按日期搜索
    @Query(value = "from BiResult where log_ymd between ? and ?")
    List<BiResult> search(Date startTimeDate, Date endTimeDate);
}
