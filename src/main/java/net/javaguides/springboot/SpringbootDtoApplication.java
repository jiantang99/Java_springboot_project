package net.javaguides.springboot;

import net.javaguides.springboot.model.Task;
import net.javaguides.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoApplication.class, args);
	}

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		Task task = new Task();
		task.setId(123456789);
		task.setTitle("Test");
		task.setDescription("Test1");
		task.setCompleted(true);
		taskRepository.save(task);
	}
}
