package yunxue.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.*;
/**
 * Application Lifecycle Listener implementation class LoginListener
 * 
 * 控制用户不能重复登录
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener, HttpSessionAttributeListener {
	
	//map保存当前登录所有用户
	public static Map<HttpSession,Long> loginUser= 
			   new HashMap<HttpSession, Long>();
	
	public static String STU_LOGIN = "stuloginer"; 
	public static String TEA_LOGIN = "tealoginer"; 

    
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	// 如果session超时, 则从map中移除这个用户
        try {
            loginUser.remove(se.getSession());
           }catch (Exception e) { 
               e.printStackTrace();
          }
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	// 如果添加的属性是用户名, 则加入map中
    	if(se.getValue().equals(STU_LOGIN)||se.getValue().equals(TEA_LOGIN)){
    		loginUser.put(se.getSession(), Long.valueOf(se.getValue().toString()));
    	}
    }

	
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	// 如果移除的属性是用户名, 则从map中移除
    	if(se.getValue().equals(STU_LOGIN)||se.getValue().equals(TEA_LOGIN)){
    		try{
    			loginUser.remove(se.getSession());
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	// 如果改变的属性是用户名, 则跟着改变map
    	if(se.getValue().equals(STU_LOGIN)||se.getValue().equals(TEA_LOGIN)){
    		loginUser.put(se.getSession(), Long.valueOf(se.getValue().toString()));
    	}
    }
    
    //判断用户是否已经登录
    public boolean isLoginUser(HttpSessionBindingEvent se,String userSession) {
        Set<HttpSession> keys = LoginListener.loginUser.keySet();
        for (HttpSession key : keys) {
            if (LoginListener.loginUser.get(key).equals(userSession)) {
                return true;
            }
        }
        return false;
     }
	
}
