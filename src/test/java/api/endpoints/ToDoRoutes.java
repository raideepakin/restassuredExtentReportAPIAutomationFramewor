package api.endpoints;

public class ToDoRoutes {

	public static String base_url="https://dummyjson.com" ;
	
	public static String  getRoute = base_url+"/todos/{todoId}";
	public static String postRoute = base_url+"/todos/add";
	public static String putRoute = base_url+"/todos/{todoId}";
	public static String deleteRoute = base_url+"/todos/{todoId}";
	public static String getwithParamsRoute = base_url+"/todos?limit={limit}&skip={skip}";
	public static String loginUrl = base_url+"/auth/login";
	public static String getCurentAuthUser = base_url+"/auth/me";
	
	
}
