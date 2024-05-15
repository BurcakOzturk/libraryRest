package dev.patika.libraryRest.api;


import dev.patika.libraryRest.business.abstracts.IAuthorService;
import dev.patika.libraryRest.business.abstracts.IBookService;
import dev.patika.libraryRest.business.abstracts.ICategoryService;
import dev.patika.libraryRest.business.abstracts.IPublisherService;
import dev.patika.libraryRest.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryRest.core.result.Result;
import dev.patika.libraryRest.core.result.ResultData;
import dev.patika.libraryRest.core.utilities.ResultHelper;
import dev.patika.libraryRest.dto.request.book.BookSaveRequest;
import dev.patika.libraryRest.dto.request.book.BookUpdateRequest;
import dev.patika.libraryRest.dto.response.CursorResponse;
import dev.patika.libraryRest.dto.response.author.AuthorResponse;
import dev.patika.libraryRest.dto.response.book.BookResponse;
import dev.patika.libraryRest.entities.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final IBookService bookService;
    private final IModelMapperService modelMapper;
    private final ICategoryService categoryService;
    private final IAuthorService authorService;
    private final IPublisherService publisherService;

    public BookController(
            IBookService bookService,
            IModelMapperService modelMapper,
            ICategoryService categoryService,
            IAuthorService authorService,
            IPublisherService publisherService
    ) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        Author author = this.authorService.get(bookSaveRequest.getBookAuthorId());
        saveBook.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookSaveRequest.getBookPublisherId());
        saveBook.setPublisher(publisher);

        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveBook, BookResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus
    public ResultData<BookResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.modelMapper.forResponse().map(this.bookService.get(id), BookResponse.class));
    }

    @GetMapping("/{id}/author")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> getAuthor(@PathVariable("id") int id) {
        return ResultHelper.success(this.modelMapper.forResponse().map(this.bookService.get(id).getAuthor(), AuthorResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Book> bookPage = this.bookService.cursor(page,pageSize);
        Page<BookResponse> bookResponsePage = bookPage.map(book -> this.modelMapper.forResponse().map(book, BookResponse.class));

        return ResultHelper.cursor(bookResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book updeteBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        this.bookService.update(updeteBook);
        return ResultHelper.success(this.modelMapper.forResponse().map(updeteBook, BookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}

