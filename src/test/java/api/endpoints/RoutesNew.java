package api.endpoints;

public class RoutesNew {

	public static String base_url = "https://reqres.in/api";
	
    
    public static String post_url = base_url+"/users";
    public static String get_url =  base_url+"/users?page=1";
    public static String put_url = base_url+"/users/{userId}";
    public static String delete_url = base_url+"/users/{userId}";
    public static String user_login_url = base_url+"/auth/login";
}
