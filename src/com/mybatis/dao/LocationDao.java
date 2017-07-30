package com.mybatis.dao;

import com.mybatis.entity.Location;

public interface LocationDao {
	/**
	 * 在接口当中定义的方法，输入参数，输出参数类型，必须和mapper.xml文件当中一致
	 * 	方法名和mapper.xml文件中的ID一致
	 * 	输入参数必须匹配
	 * 	接口当中输出值类型和mapper.xml当中一致
	 */
	
	
	/**
	 * 根据ID查询Location
	 * @param department_id
	 * @return
	 */

	
	Location selectLocationById(int location_id);

	/**
	 *向location当中增加一条数据
	 * @param location
	 * @return
	 */
	int insertLocation(Location location);
	
	/**
	 * 修改数据信息
	 * @param location_id
	 * @return
	 */
	int updateLocation(Location location);
	
	/**
	 * 删除数据
	 * @param location
	 * @return
	 */
	int deleteLocation(int location_id);

}

