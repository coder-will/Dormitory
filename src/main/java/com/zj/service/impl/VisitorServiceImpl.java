package com.zj.service.impl;


import com.zj.dao.VisitorMapper;
import com.zj.pojo.PageInfo;
import com.zj.pojo.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements com.zj.service.VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;


    //分页查询
    public PageInfo<Visitor> findPageInfo(String v_name, String v_phone , Integer pageIndex, Integer pageSize) {
        PageInfo<Visitor> pi = new PageInfo<Visitor>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = visitorMapper.totalCount(v_name,v_phone);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList =	visitorMapper.getVisitorList(v_name,v_phone,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(visitorList);
        }
        return pi;
    }


    public List<Visitor> getAll(){
        List<Visitor> visitorList = visitorMapper.getAll();
        return visitorList;
    }

    //添加学生信息
    public  int addVisitor(Visitor visitor) {
        return visitorMapper.addVisitor(visitor);
    }
}

