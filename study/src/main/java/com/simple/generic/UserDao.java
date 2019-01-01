/**
 * 
 */
package com.simple.generic;

/**
 *@author WangY
 *@Date 2017 2017年3月4日 
 */
public class UserDao extends JdbcDaoSupport<User> {

	public static void main(String[] args)
    {
        UserDao dao = new UserDao();
    }
}
