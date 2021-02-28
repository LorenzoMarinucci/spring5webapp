package spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import spring5webapp.model.Author;
import spring5webapp.model.Book;
import spring5webapp.repositories.AuthorRepository;
import spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	
	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Drive Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book  noEJB = new Book("J2EE Development without EJ8", "23444", "Worx");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
		
	}

}
