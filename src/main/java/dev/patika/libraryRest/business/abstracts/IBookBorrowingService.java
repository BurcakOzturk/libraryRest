package dev.patika.libraryRest.business.abstracts;

import dev.patika.libraryRest.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
      BookBorrowing save(BookBorrowing bookBorrowing);
      BookBorrowing get(int id);
      Page<BookBorrowing> cursor (int page, int pageSize);

      BookBorrowing update(BookBorrowing bookBorrowing);

      boolean delete(int id);

}

