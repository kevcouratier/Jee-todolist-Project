package fr.icdc.dei.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.service.TaskService;

@Controller
@RequestMapping("/tasks/finish/all")
public class FinishTasksController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView finishTasks() {
		List<Task> tasksNotFinished = taskService.listNotFinished();
		taskService.finishTasksNotFinished(tasksNotFinished);
		return new ModelAndView("redirect:/tasks");
	}

}
