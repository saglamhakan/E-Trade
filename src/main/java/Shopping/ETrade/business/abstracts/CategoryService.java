package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.business.dtos.CategoryListDto;
import Shopping.ETrade.business.request.AddCategoryRequest;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import Shopping.ETrade.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    Result add(AddCategoryRequest addCategoryRequest);

    DataResult<Category> getByCategoryId(int categoryId);

    DataResult<List<CategoryListDto>> getAll();




  //  void delete();
}
