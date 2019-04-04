package org.medex.controller;

import org.medex.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginServlet
{
	
@Autowired
private LoginDao loginDao;

@RequestMapping(value = "/login_serv", method = RequestMethod.POST)
public ModelAndView validateUsr(@RequestParam("id")String id, @RequestParam("pwd")String pwd) {
/*log.info("Is user valid?= " + isValid);*/
                String msg=" ";
                boolean isValid= loginDao.selectUser(id, pwd);
                if(isValid) {
                    msg = "Welcome ";
                } else {
                    msg = "Invalid credentials";
                }
                return new ModelAndView("patient","output", msg);

}

}
