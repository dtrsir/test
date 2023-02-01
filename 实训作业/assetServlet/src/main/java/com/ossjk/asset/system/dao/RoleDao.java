package com.ossjk.asset.system.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.ossjk.asset.base.dao.BaseDao;
import com.ossjk.asset.system.pojo.Role;

//1.根据表明创建dao 比如 role  RoleDao ，并且继承BaseDao
//2.BaseDao需要填写泛型，首先创建好role表的实体类实现Serializable接口
//3.填充实体类字段调用 roleDao.autoGenEntityTitle();
//4.setter / getter

public class RoleDao extends BaseDao<Role> {
	public static void main(String[] args) throws  Exception {
		RoleDao roleDao = new RoleDao();
	
		
		 

	}
}
