package fr.icdc.dei.todolist.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> list() {
		return taskDao.findAll();
	}

	@Override
	public Task add(Task task) {
		if(task.getUser().getTasks().size() < 10)
			return taskDao.save(task);
		return null;
	}
	
	@Override
	public List<Task> listNotFinished() {
		return taskDao.findAllWhereEndingDateSup();
	}
	
	@Override
	public void finishTaskById(long taskId) {
		taskDao.deleteTaskById(taskId);
	}
	
	@Override
	public void finishTasksNotFinished(List<Task> tasks){
		for(Iterator<Task> i = tasks.iterator(); i.hasNext(); ) {
		    Task task = i.next();
		    finishTaskById(task.getId());
		}
	}
	
	public Task getTask(long taskId){
		return taskDao.findById(taskId);
	}
}
