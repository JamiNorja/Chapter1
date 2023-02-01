package Chapter2.Thymeleaf.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Chapter2.Thymeleaf.domain.Student;


@Controller
public class StudentController {
	
	@GetMapping("/hello")
	public String sayGreetingsToStudents(Model model) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student ("Jami", "Norja"));
		students.add(new Student("Jami2", "Norja2"));
		model.addAttribute("students", students);
		return "studentList";
	}
}
