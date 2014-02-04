/**
 * @file	DashboardController.java
 * @brief   대쉬보드 처리 Controller class 
 * @author  성낙천
 * @date    생성: 2014.02.04
 * @date    최종수정: 2014.02.04 
 */

package net.secretnote.web.dashboard;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.secretnote.web.common.CommonBuilder;

/**
 * @brief 	대시보드 컨트롤러 클래스
 * @author 	성낙천
 * @version 1.0
 * @date    생성: 2014.01.23 
 * @date    최종수정: 2014.01.23 
 * @remark	대시보드 처리 클래스
 */

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@RequestMapping(value = "/view")
	public void view(HttpSession session, Model model){
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Index", "1", "1");
		
		model.addAllAttributes(defaultParam);
	}
}
