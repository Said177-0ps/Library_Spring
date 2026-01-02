package com.library.dea;

import com.library.dea.AppConfig.AppConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.print.Book;

@SpringBootApplication
public class DeaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeaApplication.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigs.class);
//
//        Book book = context.getBean(Book.class);
//        book.setTitle("Java");
//        book.setAuthor("James Gosling");
//
//        System.out.println(book.getTitle());
//        System.out.println(book.getAuthor());

	}

}
