package com.ch.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.member.model.Member;
import com.ch.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;

	@RequestMapping("joinForm.do")
	public String joinForm() {
		return "joinForm";
	}

	@RequestMapping(value = "idChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody // jsp로 가지말고 바로 본문을 전달
	public String idChk(String id) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null)
			msg = "쭈아 그 아이디야";
		else
			msg = "딴 아이디써";
		return msg;
	}

	@RequestMapping("join.do")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터이고 memebr2는 DB에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
			member.setFileName(fileName);
			FileOutputStream fos = new FileOutputStream(new File("src/main/resources/static/images/" + fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			result = ms.insert(member);
		} else
			result = -1; // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "join";
	}

	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping("login.do")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0; // 암호가 다름
		Member member2 = ms.select(member.getId());
		if (member2 == null || member2.getDel().equals("y"))
			result = -1; // 없는 ID
		else if (member2.getPassword().equals(member.getPassword())) {
			result = 1; // 성공 id와 password가 일치
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "login";
	}

	@RequestMapping("view.do")
	public String view(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}

	@RequestMapping("updateForm.do")
	public String updateForm(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "updateForm";
	}

	@RequestMapping("update.do")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
//		fileName는 null일수도 있고 값을 가지고 올 수도 있다
		String fileName = member.getFile().getOriginalFilename();
		if (fileName != null && !fileName.equals("")) {
			member.setFileName(fileName);
			FileOutputStream fos = new FileOutputStream(new File("src/main/resources/static/images/" + fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
		}
		result = ms.update(member);
		model.addAttribute("result", result);
		return "update";
	}

	@RequestMapping("delete.do")
	public String delete(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0)
			session.invalidate();
		model.addAttribute("result", result);
		return "delete";
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	@RequestMapping("main.do")
	public String main(Member member, Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		if (id != null && !id.equals("")) {
			member = ms.select(id);
			model.addAttribute("member", member);
		}
		return "main";
	}
}