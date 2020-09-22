package com.zj.service.impl;

import com.zj.dao.StudentMapper;
import com.zj.pojo.PageInfo;
import com.zj.pojo.Student;
import com.zj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid, Integer s_classid, String s_classname, Integer pageIndex, Integer pageSize) {
        PageInfo<Student> pi = new PageInfo<Student>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = studentMapper.totalCount(s_name,s_studentid,s_classid,s_classname);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student> studentList =	studentMapper.getStudentList(s_name,s_studentid,s_classid,s_classname,
                    (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(studentList);
        }
        return pi;
    }

    public int deleteStudent(Integer s_id) {
        return studentMapper.deleteStudent(s_id);
    }

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Student findStudentById(Integer s_id) {
        return studentMapper.findStudentById(s_id);
    }

    public List<Student> getAll() {
        return studentMapper.getAll();
    }
}
