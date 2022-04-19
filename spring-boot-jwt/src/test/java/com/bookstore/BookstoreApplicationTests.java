package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import com.bookstore.controller.AuthorController;
import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;

@SpringBootTest
class BookstoreApplicationTests {
	
	@MockBean
	AuthorRepository authorRepo; 

	@Autowired
	ApplicationContext context;
	
	@MockBean
	AuthorController ac;

	@Test
	void testgetAuthor() {
		// vérifie que le getID
		Author res = new Author(1,"toto","toto");
		Mockito.when(authorRepo.getById(1)).thenReturn(res);
		// test controller
		AuthorController con = context.getBean(AuthorController.class);
		Author a = con.getId(1); //
		assertEquals(res, a);
	}

	@Test
	void testgetAuthor2() {
		// vérifie que le getID
		Author res = new Author(1,"toto","toto");
		Mockito.when(authorRepo.getById(1)).thenReturn(res);
		Mockito.when(ac.getId(1)).thenCallRealMethod();
		// test controller
		Author a = ac.getId(1);
		assertEquals(res, a);
	}

}
