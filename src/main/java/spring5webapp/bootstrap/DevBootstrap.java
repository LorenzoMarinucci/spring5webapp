package spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import spring5webapp.model.Author;
import spring5webapp.model.Book;
import spring5webapp.model.Publisher;
import spring5webapp.repositories.AuthorRepository;
import spring5webapp.repositories.BookRepository;
import spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private PublisherRepository publisherRepo;
	
	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo,
											   PublisherRepository publisherRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}

	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Publisher hc = new Publisher("Harper Collins", "221B Baker St.");
		Book ddd = new Book("Domain Drive Design", "1234", hc);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		publisherRepo.save(hc);
		bookRepo.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "1234 5th Avenue");
		Book  noEJB = new Book("J2EE Development without EJ8", "23444", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepo.save(rod);
		publisherRepo.save(worx);
		bookRepo.save(noEJB);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
		
	}

}
