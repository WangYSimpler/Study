package com.simple.json.fastJson;

public class User {

	
	private Long user_id;

	private String user_name;

	public User() {

	}

	public User(Long userId, String name) {
		this.user_id = userId;
		this.user_name = name;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

public void setAge(int age) {
        
    }
    
    public int getAge() {
        return 18;
    }
    
    public void setPwd() {
        
    }
    
    public String getPwd() {
        return "pwd";
    }

	
	public static void main(String[] args) {
		
/*//		Gson gson = new Gson();
//        String res = gson.toJson(new User().init());
//        System.out.println(res);
//        
//        res = JSON.toJSONString(new User().init());
//        System.out.println(res);
//        ;
//        
//        System.out.println( JSON.toJSON(new User().init()));
*/    }
    
    public User init() {
        
        User user = new User();
        user.setUser_id(1L);
        user.setUser_name("威少");
        
        return user;

    }
}
