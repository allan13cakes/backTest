package automation.repositories;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import automation.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {
	@Autowired
	private ProjectRepository projectRepository;
	@Test
	public void listProjectTest() {
		List<Project> listProject = (List<Project>) projectRepository.findAll();
		System.out.println(listProject.size());
		for(Project project:listProject) {
			System.out.println(project);
		}
	}
	
	@Test
	public void saveProject() {
		Project project = new Project("test project1",new Date());
		project = projectRepository.save(project);
		System.out.println(project);
	}
}
