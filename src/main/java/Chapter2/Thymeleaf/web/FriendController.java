package Chapter2.Thymeleaf.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Chapter2.Thymeleaf.domain.Friend;

@Controller 
public class FriendController {
	
	private ArrayList<String> friends = new ArrayList<>();
	
	@GetMapping("/friend")
	public String handleFriends(@RequestParam(name="nimi", required=false) String name,
			Model model) {
		if (name != null) {
			friends.add(name);
		}
		model.addAttribute("friends", friends);
		return "friends";
	}
	
	/* Toinen tapa */
	
	private ArrayList<Friend> friends2 = new ArrayList<>();
	
	@GetMapping(value= "/friend2")
	public String handleFriends2(Model model) {
		model.addAttribute("friendsList2", friends2);
		model.addAttribute("friend2", new Friend());
		return "friends2";
	}
	
	@PostMapping("/friend2")
	public String addFriend(@ModelAttribute Friend ystava2) {
		friends2.add(ystava2);
		return "redirect:/friend2";
	}
}
