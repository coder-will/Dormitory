package com.zj.service.impl;

import com.zj.dao.AdminMapper;
import com.zj.pojo.Admin;
import com.zj.pojo.PageInfo;
import com.zj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdmin(Admin admin) {
        return adminMapper.findAdmin(admin);
    }

    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    public int deleteAdmin(Integer a_id) {
        return adminMapper.deleteAdmin(a_id);
    }

    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    public Admin findAdminById(Integer a_id) {
        return adminMapper.findAdminById(a_id);
    }

    public List<Admin> getAllAdmin() {
        return adminMapper.getAllAdmin();
    }

    public Integer totalCount(String a_username, String a_describe, Integer a_id) {
        return null;
    }

    public List<Admin> getAdminList(String a_username, String a_describe, Integer a_id, Integer currentPage, Integer pageSize) {
        return null;
    }

    public PageInfo<Admin> findPageInfo(String a_username, String a_describe, Integer a_id, Integer pageIndex, Integer pageSize) {
        PageInfo<Admin> pi = new PageInfo<Admin>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = adminMapper.totalCount(a_username,a_describe,a_id);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Admin> adminList =	adminMapper.getAdminList(a_username,a_describe,a_id,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(adminList);
        }
        return pi;
    }

}
