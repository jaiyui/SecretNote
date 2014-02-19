package net.secretnote.web.note;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.secretnote.web.common.CommonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/note")
@SessionAttributes("Note")
public class NoteController {
	@Autowired NoteService noteService;

	@RequestMapping(value = "/index")
	public String noteList(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		return "/note/list";
	}
	
	@RequestMapping(value = "/create")
	public String noteCreate(HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		return "/note/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid Note note, Errors errors)
	{
		if (errors.hasErrors()) return "/note/create";	
		noteService.create(note); 
		
		return "redirect:index";
	}

	@RequestMapping(value = "/noteview.diary")
	public String viewDiary(String noteIdx, HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		model.addAttribute("noteIdx", noteIdx);
		return "/note/viewDiary";
	}

	@RequestMapping(value = "/noteview.ediary")
	public String viewExchangeDiary(String noteIdx, HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		model.addAttribute("noteIdx", noteIdx);
		return "/note/viewExchangeDiary";
	}

	@RequestMapping(value = "/noteview.novel")
	public String viewNovel(String noteIdx, HttpSession session, Model model)
	{
		HashMap<String, String> defaultParam = CommonBuilder.CommonSetter(session);
		defaultParam = CommonBuilder.MenuSetter(defaultParam, "Note", "1", "1");
		
		model.addAllAttributes(defaultParam);
		model.addAttribute("noteIdx", noteIdx);
		return "/note/viewNovel";
	}

	// API
	@RequestMapping(value = "/getlist", method = RequestMethod.POST)
	@ResponseBody
	public List<Note> getList(String userIdx)
	{
		List<Note> list = noteService.list(Integer.valueOf(userIdx), null);
		return list;
	}

	//
	@RequestMapping(value = "/getnote", method = RequestMethod.POST)
	@ResponseBody
	public Note getnote(int noteIdx)
	{
		Note note = noteService.read(noteIdx);
		return note;
	}
}
