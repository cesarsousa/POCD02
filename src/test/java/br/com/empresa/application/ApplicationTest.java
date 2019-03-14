package br.com.empresa.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.empresa.application.Application;

@SpringBootTest(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {
	@Test
	public void configure() {
		Application application = new Application();
		Assert.assertNotNull(application.configure(new SpringApplicationBuilder()));
	}
	
	@Test
	public void main() {
		Runnable runnable = new Runnable() {		
			@Override
			public void run() {
				Application.main(new String[] {});
			}
		};
		Thread thread = new Thread(runnable);
		thread.run();
		thread.interrupt();
	}
}
