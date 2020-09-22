package com.zj.service.impl;
import com.zj.pojo.Class;
import com.zj.dao.ClassMapper;
import com.zj.pojo.PageInfo;
import com.zj.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {
	// classDao
	@Autowired
	private ClassMapper classMapper;


	//分页查询
	public PageInfo<Class> findPageInfo(String c_classname, String c_counsellor, Integer c_classid, Integer pageIndex, Integer pageSize) {
		PageInfo<Class> pi = new PageInfo<Class>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = classMapper.totalCount(c_classname,c_classid,c_counsellor);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示班级信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
			List<Class> classList =	classMapper.getClassList(c_classname,c_classid,c_counsellor,
					(pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
			pi.setList(classList);
		}
		return pi;
	}

	public List<Class> getAll(){
		List<Class> classList = classMapper.getAll();
		return  classList;
	}

	//通过id删除班级信息
	public int deleteClass(Integer c_id) {
		return classMapper.deleteClass(c_id);
	}

	//添加班级信息
	public int addClass(Class uclass) {
		return classMapper.addClass(uclass);
	}

	public Class findClassById (Integer c_id){
		Class c = classMapper.findClassById(c_id);
		return  c;
	}
	//修改班级信息
	public int updateClass(Class uclass) {
		return classMapper.updateClass(uclass);
	}

	//查询宿舍人员信息
	public List<Class> findClassStudent(Class uclass) {
		List<Class> c = classMapper.findClassStudent(uclass);
		return c;
	}
}
