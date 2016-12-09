package fr.icdc.dei.todolist.persistence.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class TaskDaoImpl implements TaskDao {
  
    //@PersistenceContext
    //private EntityManager manager;
    
    
	
	public void deleteTaskById(Long taskId){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("Task");
		
		EntityManager manager = emf.createEntityManager();
		
	    Task task = manager.find(Task.class, taskId);
	    if (task != null) {
	        manager.getTransaction().begin();
	        manager.remove(task);
	        manager.getTransaction().commit();
	    }
	    emf.close();
	}
}