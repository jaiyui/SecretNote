package net.secretnote.web.note;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import net.secretnote.web.common.CommonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {
	@Autowired NoteService noteService;

	@RequestMapping(value = "/index")
	public String noteList(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		return "/note/noteList";
	}
	
}
