package com.zj.service.impl;


import com.zj.dao.DormCleanMapper;
import com.zj.pojo.DormClean;
import com.zj.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements com.zj.service.DormCleanService {
    // classDao
    @Autowired
    private DormCleanMapper dormCleanMapper;


    //分页查询
    public PageInfo<DormClean> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormClean> pi = new PageInfo<DormClean>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormCleanMapper.totalCount(d_id,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormClean> dormCleanList =	dormCleanMapper.getDormCleanList(d_id,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormCleanList);
        }
        return pi;
    }

    public List<DormClean> getAll(){
        List<DormClean> dormCleanList = dormCleanMapper.getAll();
        return dormCleanList;
    }

    //添加宿舍卫生信息
    public int addDormClean(DormClean dormclean) {
        return dormCleanMapper.addDormClean(dormclean);
    }

    //通过id删除宿舍卫生信息
    public int deleteDormClean(Integer g_id) {
        return dormCleanMapper.deleteDormClean(g_id);
    }

    //修改宿舍卫生信息
    public int updateDormClean(DormClean dormclean) {
        return dormCleanMapper.updateDormClean(dormclean);
    }

    public DormClean findDormCleanById (Integer g_id){
        DormClean d = dormCleanMapper.findDormCleanById(g_id);
        return  d;
    }

}

