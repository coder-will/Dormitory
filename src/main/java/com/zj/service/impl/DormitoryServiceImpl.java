package com.zj.service.impl;


import com.zj.dao.DormitoryMapper;
import com.zj.pojo.Dormitory;
import com.zj.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements com.zj.service.DormitoryService {
	// classDao
	@Autowired
	private DormitoryMapper dormitoryMapper;


	//分页查询
	public PageInfo<Dormitory> findPageInfo(String a_name, Integer s_dormitoryid, String d_dormbuilding, Integer pageIndex, Integer pageSize) {
		PageInfo<Dormitory> pi = new PageInfo<Dormitory>();
		pi.setPageIndex(pageIndex);
		pi.setPageSize(pageSize);
		//获取总条数
		Integer totalCount = dormitoryMapper.totalCount(a_name,s_dormitoryid,d_dormbuilding);
		if (totalCount>0){
			pi.setTotalCount(totalCount);
			//每一页显示宿舍信息数
			//currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
		List<Dormitory> dormitoryList =	dormitoryMapper.getDormitoryList(a_name,s_dormitoryid,d_dormbuilding,
				     (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
		  pi.setList(dormitoryList);
		}
		return pi;
	}

	public List<Dormitory> getAll(){
		List<Dormitory> dormitoryList = dormitoryMapper.getAll();
		return dormitoryList;
	}

	//添加宿舍信息
	public int addDormitory(Dormitory dormitory) {
		return dormitoryMapper.addDormitory(dormitory);
	}

	//通过id删除宿舍信息
	public int deleteDormitory(Integer d_id) {
		return dormitoryMapper.deleteDormitory(d_id);
	}

	//修改宿舍信息
	public int updateDormitory(Dormitory dormitory) {
		return dormitoryMapper.updateDormitory(dormitory);
	}

	public Dormitory findDormitoryById (Integer d_id){
		Dormitory d = dormitoryMapper.findDormitoryById(d_id);
		return  d;
	}
	//查询宿舍人员信息
	public List<Dormitory> findDormitoryStudent(Dormitory dormitory) {
		List<Dormitory> d = dormitoryMapper.findDormitoryStudent(dormitory);
		return d;
	}


}
