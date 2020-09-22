package com.zj.service.impl;


import com.zj.dao.DormRepairMapper;
import com.zj.pojo.DormRepair;
import com.zj.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements com.zj.service.DormRepairService {

    @Autowired
    private DormRepairMapper dormRepairMapper;


    //分页查询
    public PageInfo<DormRepair> findPageInfo(Integer d_id, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
        PageInfo<DormRepair> pi = new PageInfo<DormRepair>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = dormRepairMapper.totalCount(d_id,d_dormbuilding);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<DormRepair> dormRepairList =	dormRepairMapper.getDormRepairList(d_id,d_dormbuilding,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(dormRepairList);
        }
        return pi;
    }

    public List<DormRepair> getAll(){
        List<DormRepair> dormRepairList = dormRepairMapper.getAll();
        return dormRepairList;
    }

    //添加宿舍信息
    public int addDormRepair(DormRepair dormrepair) {
        return dormRepairMapper.addDormRepair(dormrepair);
    }

    //通过id删除宿舍信息
    public int deleteDormRepair(Integer r_id) {
        return dormRepairMapper.deleteDormRepair(r_id);
    }

    //修改宿舍信息
    public int updateDormRepair(DormRepair dormrepair) {
        return dormRepairMapper.updateDormRepair(dormrepair);
    }

    public DormRepair findDormRepairById (Integer r_id){
        DormRepair d = dormRepairMapper.findDormRepairById(r_id);
        return  d;
    }

}

