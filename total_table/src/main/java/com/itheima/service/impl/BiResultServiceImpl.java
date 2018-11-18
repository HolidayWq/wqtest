package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.BiResultDao;
import com.itheima.domain.BiResult;
import com.itheima.service.BiResultService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BiResultServiceImpl implements BiResultService {


    @Autowired
    private BiResultDao biResultDao;


    //查询所有不分页
    @Override
    public List<BiResult> list() {
        return biResultDao.findAll();
    }

    //搜索不分页
    @Override
    public List<BiResult> search(String startTime, String endTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTimeDate = null;
        Date endTimeDate = null;
        try {
            //将字符串转换为日期格式
            startTimeDate = simpleDateFormat.parse(startTime);
            endTimeDate = simpleDateFormat1.parse(endTime);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return biResultDao.search(startTimeDate,endTimeDate);
        //return biResultDao.search(startTimeDate,endTimeDate);
    }

    //分页查询 不行
    @Override
    public PageInfo<BiResult> getAllPage(BiResult biResult, int page, int size) {
        //静态分页方法
        PageHelper.startPage(page,size);
        Configuration configuration =new Configuration().configure();
        BootstrapServiceRegistry bootstrapServiceRegistry = new BootstrapServiceRegistryBuilder().build();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria =session.createCriteria(BiResult.class);
        criteria.add(Example.create(biResult));
        Pageable pageable =new PageRequest(page,size);

        return null;
    }
}
