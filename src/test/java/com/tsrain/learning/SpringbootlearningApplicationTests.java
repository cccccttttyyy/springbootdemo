package com.tsrain.learning;

import com.tsrain.learning.job.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootlearningApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private AsyncService  asyncService;
	@Test
	public void test() throws Exception {
		long startTime = System.currentTimeMillis();
		asyncService.sendA();
		asyncService.sendB();

		long endTime = System.currentTimeMillis();
		System.out.println("AB总耗时：" + (endTime - startTime));
		startTime = System.currentTimeMillis();

		Future<String> task1 = asyncService.sendC();
		Future<String> task2 =asyncService.sendD();

		while(true) {
			if(task1.isDone() && task2.isDone() ) {
				break;
			}
		}

		endTime = System.currentTimeMillis();
		System.out.println("CD总耗时：" + (endTime - startTime));
	}

}
