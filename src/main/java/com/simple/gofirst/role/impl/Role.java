package com.simple.gofirst.role.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.simple.gofirst.service.ConnectSerivce;

public class Role   {

	/*///返回ISee中用到的Map
	Map 如 GA {GAA1={GAA102=true, GAA101=true}, GAW1={GAW101=true}}*/
	public static  Map<String, Map<String, Map<String, Boolean>>> getUserRolesModulesGroupsMap(ResultSet inResultSet) {

		System.out.println(" input getUserModulesGroup Function");
		////// 转化成需要使用的Map
		Map<String, Map<String, Map<String, Boolean>>> userRolesModulesGroupMap = new HashMap<String, Map<String, Map<String, Boolean>>>();
		
		/// 结果集赋值
		ResultSet queryResultSet = inResultSet;
		/// 提出结果来
		/// 存放当前模块信息
		String lastModuleNo = "";

		/// 模块，模组信息
		Map<String, String> userModuleGroupMap = new HashMap<String, String>();
		/// 中间模块和表达信息
		Map<String, Map<String, Boolean>> modulesRolesMap = new HashMap<>();
		/// 中间
		Map<String, Boolean> RoleTempMap = new HashMap<>();

		try {

			while (queryResultSet.next()) {

				String moduleStr = queryResultSet.getString("module_no");
				String moduleGroupStr = queryResultSet.getString("upModule");
				/// 获取模块，模组信息
				if (moduleStr != null) {
					userModuleGroupMap.put(moduleStr, moduleGroupStr);
				}

				String roleNoStr = queryResultSet.getString("role_no");
				String currentmoduleNoStr = queryResultSet.getString("module_no");

				// 把结果集中数据进行获取,初始的模块编号不存在
				if (!lastModuleNo.equals(currentmoduleNoStr)) {

					if (!lastModuleNo.equals("")) {

						/// 测试代码
						/*
						 * System.out.println("==========**测试**=======");
						 * System.out.println(currentmoduleNoStr); for
						 * (Entry<String, Boolean> m : RoleTempMap.entrySet()) {
						 * System.out.println(m.getKey() + " " + m.getValue());
						 * } System.out.println("==========**测试结束**=======");
						 */

						Map<String, Boolean> newMap = new HashMap<String, Boolean>();
						newMap.putAll(RoleTempMap);
						modulesRolesMap.put(lastModuleNo, newMap);

						RoleTempMap.clear();
					}

					lastModuleNo = currentmoduleNoStr;

				}
				RoleTempMap.put(roleNoStr, true);

			}
			/// 模块和表达
			modulesRolesMap.put(lastModuleNo, RoleTempMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		String currentModuleGroupStr = "", lastModuleGroupStr = "";

		Map<String, Map<String, Boolean>> tempModulesRolesMap = new HashMap<>();

		for (Entry<String, Map<String, Boolean>> m : modulesRolesMap.entrySet()) {
			/// 获取当前模组的信心
			currentModuleGroupStr = userModuleGroupMap.get(m.getKey());
			/// 将该模块进行翻入临时Temp中
			
			if (!lastModuleGroupStr.equals(currentModuleGroupStr)) {
				if (!lastModuleGroupStr.equals("")) {
					Map<String, Map<String, Boolean>> newModulesRolesMap = new HashMap<>();
					newModulesRolesMap.putAll(tempModulesRolesMap);
					userRolesModulesGroupMap.put(lastModuleGroupStr, newModulesRolesMap);
					tempModulesRolesMap.clear();
				}
				lastModuleGroupStr = currentModuleGroupStr;
			}

			tempModulesRolesMap.put(m.getKey(), m.getValue());
			// 打印当前模组编号
			// System.out.println(userModuleGroupMap.get(m.getKey()));
		}

		userRolesModulesGroupMap.put(lastModuleGroupStr, tempModulesRolesMap);

		System.out.println("==========**测试权限Map结果**=======");

		for (Entry<String, Map<String, Map<String, Boolean>>> mEntity : userRolesModulesGroupMap.entrySet()) {
			System.out.println(mEntity.getKey() + " " + mEntity.getValue());
		}

		// return userModulesMap;

		/*
		 * /// 输出结果模组和权限 for (Entry<String,Map<String, Boolean>> m :
		 * modulesRolesMap.entrySet()) { System.out.println(m.getKey() + " " +
		 * m.getValue()); }
		 */

		return userRolesModulesGroupMap;

	}

	//获取<模块，模组MaP>
	public Map<String, String> getModulesGroupMap(ResultSet inResultSet) {
		ResultSet queryResultSet = inResultSet;

		HashMap<String, String> resultMap = new HashMap<>();
		try {

			while (queryResultSet.next()) {
				String moduleStr = queryResultSet.getString("module_no");
				String moduleGroupStr = queryResultSet.getString("upModule");

				if (moduleStr != null) {
					resultMap.put(moduleStr, moduleGroupStr);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("==========**函数中测试**=======");
		System.out.println();
		for (Entry<String, String> m : resultMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println("==========**测试结束**=======");

		return resultMap;

	}

	public Map<String, Map<String, Map<String, Boolean>>> getUserRolesMap(ResultSet inResultSet) {

		Map<String, Map<String, Map<String, Boolean>>> userModulesMap = new HashMap<String, Map<String, Map<String, Boolean>>>();

		/// 模块和模组的结果集
		ResultSet userModuleGroupSet = inResultSet;
		Map<String, String> userModuleGroupMap = this.getModulesGroupMap(userModuleGroupSet);

		/// 用户模块和
		//ResultSet userModuleRoleSet = inResultSet1;
		Map<String, Map<String, Boolean>> userModuleRolesMap = new HashMap<>();// this.getModulesRolesMap(userModuleRoleSet);

		System.out.println("==========**测试ModuleRole**=======");
		System.out.println();
		String currentModuleGroupStr = "", lastModuleGroupStr = "";

		Map<String, Map<String, Boolean>> tempModulesRolesMap = new HashMap<>();

		for (Entry<String, Map<String, Boolean>> m : userModuleRolesMap.entrySet()) {
			/// 获取当前模组的信心
			currentModuleGroupStr = userModuleGroupMap.get(m.getKey());
			/// 将该模块进行翻入临时Temp中

			if (!lastModuleGroupStr.equals(currentModuleGroupStr)) {
				if (!lastModuleGroupStr.equals("")) {
					Map<String, Map<String, Boolean>> newModulesRolesMap = new HashMap<>();
					newModulesRolesMap.putAll(tempModulesRolesMap);
					userModulesMap.put(lastModuleGroupStr, newModulesRolesMap);
					tempModulesRolesMap.clear();
				}
				lastModuleGroupStr = currentModuleGroupStr;
			}

			tempModulesRolesMap.put(m.getKey(), m.getValue());
			System.out.println(userModuleGroupMap.get(m.getKey()));
		}

		userModulesMap.put(lastModuleGroupStr, tempModulesRolesMap);

		System.out.println("==========**测试结束**=======");

		for (Entry<String, Map<String, Map<String, Boolean>>> mEntity : userModulesMap.entrySet()) {
			System.out.println(mEntity.getKey() + " " + mEntity.getValue());
		}

		return userModulesMap;

	}

	public Map<String, Boolean> resultSettoMap(ResultSet inResultSet, String columnStr) {

		ResultSet queryResultSet = inResultSet;
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

		try {

			while (queryResultSet.next()) {

				String queryStr = queryResultSet.getString(columnStr);

				if (queryStr != null) {

					/* System.out.println("模组/模块:" + queryStr); */
					// 按照字段的字符为主键存在
					resultMap.put(queryStr, true);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * // 遍历map 测试 for (Entry<String, Boolean> m : resultMap.entrySet()) {
		 * System.out.println(m.getKey() + " " + m.getValue()); }
		 */
		return resultMap;

	}

	public void TestOracle() throws SQLException {
		/// 测试sql
		// String sql = "select hom.module_id,hm.module_no,hm.module_name from
		/// hy_org_modules hom ,hy_modules hm where hom.module_id >11 and
		/// hm.module_id = hom.module_id";

		String sqlStr = "select distinct hor.role_id,hr.role_no,hor.module_id,hm.module_no,othm.module_no as upModule "
				+ "from hy_systems hs,hy_org_systems hos,hy_modules hm ,hy_org_modules hom,hy_roles hr,hy_org_roles hor, hy_users hu,hy_user_usergroups hug,hy_usergroup_roles hgr ,hy_modules othm "
				+ "where hm.module_up_id = othm.module_id and hm.module_up_id >0 and (hs.system_id = hos.system_id and hm.module_id = hom.module_id and hm.system_id = hs.system_id and hr.role_id = hor.role_id ) "
				+ "and ( hor.module_id = hom.module_id and hor.system_id = hos.system_id)and (hug.user_id=hu.user_id and hug.usergroup_id = hgr.usergroup_id and hgr.role_id =hor.role_id and  hgr.module_id= hor.module_id) "
				+ "and hu.user_no ='1' and hor.role_id > 20  order by hor.role_id,hm.module_no";

		// String sqlModuleGroup = "select hm.module_no,othm.module_no as
		// upModule from hy_modules hm left join hy_modules othm on
		// hm.module_up_id = othm.module_id where hm.module_up_id >0 order by
		// upModule";

		ConnectSerivce connSerivce = new ConnectSerivce();
		// this.getModulesGroupMap(connSerivce.getModulesResultSet(sqlModuleGroup));

		
		//this.getUserRolesModulesGroupsMap(connSerivce.getModulesResultSet(sqlStr));
	
		getUserRolesModulesGroupsMap(connSerivce.getModulesResultSet(sqlStr));
		
		/*System.out.println(map.size());

		for (Entry<String, Map<String, Map<String, Boolean>>> mEntity : map.entrySet()) {
			System.out.println(mEntity.getKey() + " " + mEntity.getValue());
		}*/
		connSerivce.closedb();
		// Map<String, Boolean> moudlesResultSet =
		// connSerivce.getResultSet("select * from hy_modules t");
		// getUserModules();
	}

	public static void main(String[] args) throws SQLException {
		new Role().TestOracle();

	}

}
