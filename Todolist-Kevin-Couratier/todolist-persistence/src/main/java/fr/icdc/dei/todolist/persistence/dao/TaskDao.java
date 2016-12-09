package fr.icdc.dei.todolist.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.Task;
import org.springframework.data.jpa.repository.Query;

public interface TaskDao extends JpaRepository<Task, Long>{

	Task findByLabel(String label);

	List<Task> findAllByUserIdAndCategoryId(long idUser, long idCategory);
	
	@Query("select t from Task t where t.endingDate > NOW()")
	List<Task> findAllWhereEndingDateSup();
	
	void deleteTaskById(long taskId);

	Task findById(long taskId);

}
