package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;

public class TaskDaoTest extends AbstractDaoTest {

	private static final long FOURTH_CATEGORY_DB = 4L;
	private static final long FIRST_USER_DB = 1L;
	private static final String TEST_FINDABLE_LABEL_DB = "testFindableLabelDB";
	private static final long FIRST_TASK_DB = 1L;

	@Autowired
	private TaskDao taskDao;
	
	private final static Task task = new Task();

	@Test
	public void testCreateTask() {
		task.setLabel("");
		assertNotNull(taskDao.save(task));
	}
	
	@Test
	public void testTaskIsFindableByLabel() {
		assertNotNull(taskDao.findByLabel(TEST_FINDABLE_LABEL_DB));
	}
	
	@Test
	public void testListTasksForGivenUserAndCategory() {
		assertTrue(CollectionUtils.isNotEmpty(taskDao.findAllByUserIdAndCategoryId(FIRST_USER_DB, FOURTH_CATEGORY_DB)));
	}
	
	@Test
	public void testListTasksNotFinished(){
		assertTrue(CollectionUtils.isNotEmpty(taskDao.findAllWhereEndingDateSup()));
	}
	
	@Test
	public void testFindById(){
		assertNotNull(taskDao.findById(FIRST_TASK_DB));
	}
	
	@Test
	public void testDeleteTaskById(){
		testFindById();
		taskDao.deleteTaskById(FIRST_TASK_DB);
		assertNull(taskDao.findById(FIRST_TASK_DB));
	}
	


}
