package dev.patika.libraryRest.api;


import dev.patika.libraryRest.business.abstracts.ICategoryService;
import dev.patika.libraryRest.core.config.modelMapper.IModelMapperService;
import dev.patika.libraryRest.core.result.Result;
import dev.patika.libraryRest.core.result.ResultData;
import dev.patika.libraryRest.core.utilities.ResultHelper;
import dev.patika.libraryRest.dto.request.category.CategorySaveRequest;
import dev.patika.libraryRest.dto.request.category.CategoryUpdateRequest;
import dev.patika.libraryRest.dto.response.CursorResponse;
import dev.patika.libraryRest.dto.response.category.CategoryResponse;
import dev.patika.libraryRest.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus
    public ResultData<CategoryResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.modelMapper.forResponse().map(this.categoryService.get(id), CategoryResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Category> categoryPage = this.categoryService.cursor(page,pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage.map(category -> this.modelMapper.forResponse().map(category, CategoryResponse.class));

        return ResultHelper.cursor(categoryResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        Category updateCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateCategory, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }
}

