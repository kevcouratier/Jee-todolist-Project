package fr.icdc.dei.todolist.service;

import java.util.List;
import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskService {

	List<Task> list();

	Task add(Task task);
	
	List<Task> listNotFinished();
	
	void finishTaskById(long taskId);
	
	Task getTask(long taskId);
	
	void finishTasksNotFinished(List<Task> tasks);

}
