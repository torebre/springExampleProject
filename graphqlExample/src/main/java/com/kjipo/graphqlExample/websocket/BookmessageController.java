package com.kjipo.graphqlExample.websocket;


import com.kjipo.graphqlExample.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BookmessageController {

    private final BookRepository bookRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmessageController.class);

    public BookmessageController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @MessageMapping("/bookid")
    @SendTo("/topic/book-message")
    public BookMessage bookmessage(BookIdMessage bookIdMessage) {
        long bookId = Long.parseLong(bookIdMessage.getBookid());

        LOGGER.info("Generating book message for id {}", bookId);

        // TODO Just for testing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var book = bookRepository.findById(bookId).orElse(null);

        if (book == null) {
            return new BookMessage(bookId, null);
        }

        return new BookMessage(bookId, book.getTitle());
    }

}
