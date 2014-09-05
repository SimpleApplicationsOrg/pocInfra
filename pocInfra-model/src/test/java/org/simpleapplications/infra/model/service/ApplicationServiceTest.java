package org.simpleapplications.infra.model.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simpleapplications.infra.model.InfraModelApplicationTest;
import org.simpleapplications.infra.model.entity.Application;
import org.simpleapplications.infra.model.entity.Label;
import org.simpleapplications.infra.model.entity.LabelPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfraModelApplicationTest.class)
@ActiveProfiles("test")
public class ApplicationServiceTest {

	@Autowired
	ApplicationService service;
	
	@Test
	public void testFindApplication() {
		Application application = service.findApplication("test");
		assertNotNull(application);
	}
	
	@Test
	public void testSaveApplication() {
		Application application = new Application();
		application.setCode("test2");
		application.setName("Second Test Application");
		service.save(application);
		assertNotNull(service.findApplication("test2"));
	}
	
	@Test
	public void testDeleteApplication() {
		Application application = service.findApplication("test");
		service.delete(application);
		assertNull(service.findApplication("test"));
	}
	
	@Test
	public void testPopulateLabels() {
		Application application = service.findApplication("test1");
		service.populateLabels(application);
		assertNotEquals(0,application.getLabels().size());
	}
	
	@Test
	public void testAddLabel() {
		Application application = service.findApplication("test1");
		service.populateLabels(application);
		LabelPK id = new LabelPK();
		id.setApplicationCode(application.getCode());
		id.setCode("test1.label");
		id.setLanguage("fr");
		Label label = new Label();
		label.setId(id);
		label.setText("Label for test1");
		application.getLabels().add(label);
		service.save(application);
		service.populateLabels(application);
		assertEquals(2,application.getLabels().size());
	}
	
	@Test
	public void testRemoveLabel() {
		Application application = service.findApplication("test3");
		service.populateLabels(application);
		application.getLabels().remove(0);
		service.save(application);
		service.populateLabels(application);
		assertEquals(0,application.getLabels().size());
	}
	

	@Test
	public void testModifyLabel() {
		Application application = service.findApplication("test1");
		service.populateLabels(application);
		Label label = application.getLabels().get(0);
		label.setText("MODIFIED TEXT");
		service.save(application);
		service.populateLabels(application);
		assertEquals("MODIFIED TEXT", application.getLabels().get(0).getText());
	}
}
