package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository bookRepository, UserRepository userRepository) {
        return args -> {
            bookRepository.save(new Book("The Alchemist", "Paulo Coelho"));
            userRepository.save(new User("Diya"));
        };
    }
}
