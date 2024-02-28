package api.payload;

public class ToDo {

	public static int id;
	public static String todo;
	public static boolean completed;
	public static  int userId;
	public static String getTodo() {
		return todo;
	}
	public  void setTodo(String todo) {
		ToDo.todo = todo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
public int getId() {
	
	return  this.id;
}


	public  boolean isCompleted() {
		return completed;
	}
	public  void setCompleted(boolean completed) {
		ToDo.completed = completed;
	}
	public   int getUserId() {
		return userId;
	}
	public   void setUserId(int userId) {
		ToDo.userId = userId;
	}
}
