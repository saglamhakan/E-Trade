package Shopping.ETrade.Controllers;

import Shopping.ETrade.business.abstracts.CategoryService;
import Shopping.ETrade.business.dtos.CategoryListDto;
import Shopping.ETrade.business.request.AddCategoryRequest;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import Shopping.ETrade.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/getAll")
    public DataResult<List<CategoryListDto>> getAll() {
        return this.categoryService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody AddCategoryRequest addCategoryRequest) {
        return this.categoryService.add(addCategoryRequest);

    }
    public DataResult<Category> getByCategoryId(int categoryId) {
        return this.categoryService.getByCategoryId(categoryId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(){
        categoryService.delete();
        return ResponseEntity.ok().build();
    }


}
