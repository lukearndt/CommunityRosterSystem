package rostersystem.actions;

import com.opensymphony.xwork2.ActionSupport; 

public class HelloWorld extends ActionSupport {
  private String message;

  public String getCool() {
	  return "AWESOME";
  }
  
  public String getMessage() {
    return message;
  }

  public String execute() {
    message = "Hello World!";
    return SUCCESS;
  }
}
