package com.zj.service.impl;


import com.zj.dao.StudentCleanMapper;
import com.zj.pojo.PageInfo;
import com.zj.pojo.StudentClean;
import com.zj.service.StudentCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentCleanService")
@Transactional
public class StudentCleanServiceImpl implements StudentCleanService {


    @Autowired
    private StudentCleanMapper studentCleanMapper;


    //分页查询
    public PageInfo<StudentClean> findPageInfo(Integer s_studentid, String s_name, Integer s_dormitoryid, Integer pageIndex, Integer pageSize) {
        PageInfo<StudentClean> pi = new PageInfo<StudentClean>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = studentCleanMapper.totalCount(s_studentid,s_name,s_dormitoryid);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<StudentClean> studentCleanList =	studentCleanMapper.getStudentCleanList(s_studentid,s_name,s_dormitoryid,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(studentCleanList);
        }
        return pi;
    }


    public List<StudentClean> getAll(){
        List<StudentClean> studentCleanList = studentCleanMapper.getAll();
        return studentCleanList;
    }

    //添加宿舍卫生信息
    public int addStudentClean(StudentClean studentclean) {
        return studentCleanMapper.addStudentClean(studentclean);
    }

    //通过id删除宿舍卫生信息
    public int deleteStudentClean(Integer g_id) {
        return studentCleanMapper.deleteStudentClean(g_id);
    }

    //修改宿舍卫生信息
    public int updateStudentClean(StudentClean studentclean) {
        return studentCleanMapper.updateStudentClean(studentclean);
    }


    public StudentClean findStudentCleanById (Integer g_id){
        StudentClean d = studentCleanMapper.findStudentCleanById(g_id);
        return  d;
    }

}

