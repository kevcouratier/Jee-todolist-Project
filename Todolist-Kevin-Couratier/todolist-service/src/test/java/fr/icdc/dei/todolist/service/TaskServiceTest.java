package fr.icdc.dei.todolist.service;

import static org.junit.Assert.*;

import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

public class TaskServiceTest extends AbstractServiceTest {
	
	private static final String TASK_LABEL = "taskLabel";
	private static final long FIRST_TASK_DB = 1L;

	private final static Task task = new Task();
	private final static User user = new UserFree();

	@Autowired
	private TaskService taskService;
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
		user.setId(2L);
		task.setUser(user);
	}

	@Test
	public void testListTasks() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.list()));
	}
	
	@Test
	public void testAddTaskSucceedWithLessThanTenTasksForFreeUser() {
		assertNotNull(taskService.add(task));
	}
	
	@Test
	public void testListNotFinished() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.listNotFinished()));
	}
	
	@Test
	public void testGetTask() {
		assertNotNull(taskService.getTask(FIRST_TASK_DB));
	}
	
	@Test
	public void testFinishTaskById() {
		testGetTask();
		taskService.finishTaskById(FIRST_TASK_DB);
		assertNull(taskService.getTask(FIRST_TASK_DB));
	}
	
	@Test
	public void testFinishTasksNotFinished() {
		testListNotFinished();
		taskService.finishTasksNotFinished(taskService.listNotFinished());
		assertTrue(CollectionUtils.isEmpty(taskService.listNotFinished()));
	}
}
