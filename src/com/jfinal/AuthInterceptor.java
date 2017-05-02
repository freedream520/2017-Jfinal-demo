package com.jfinal;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class AuthInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation ai) {
		// TODO Auto-generated method stub
		Controller controller = ai.getController();
		/*User loginUser = controller.getSessionAttr("loginUser");
		if (loginUser != null && loginUser.canVisit(ai.getActionKey()))
			ai.invoke();
		else
			controller.redirect("/login.html");
		*/
		ai.invoke();
		System.out.println("---------Ö´ÐÐÈ«¾ÖÀ¹½ØÆ÷---------");
	}

}
