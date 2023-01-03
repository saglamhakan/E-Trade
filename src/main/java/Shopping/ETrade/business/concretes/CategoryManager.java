package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.CategoryService;
import Shopping.ETrade.business.dtos.CategoryListDto;
import Shopping.ETrade.business.request.AddCategoryRequest;
import Shopping.ETrade.dataaccess.abstracts.ProductsDao;
import Shopping.ETrade.result.*;
import Shopping.ETrade.dataaccess.abstracts.CategoryDao;
import Shopping.ETrade.entities.concretes.Category;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;
    private final ProductsDao productsDao;


    @Autowired
    public CategoryManager(CategoryDao categoryDao, ProductsDao productsDao) {
        this.categoryDao = categoryDao;
        this.productsDao = productsDao;
    }


    @Override
    public Result add(AddCategoryRequest addCategoryRequest) {
        if (this.validateRequest(addCategoryRequest)) {
            Category category = this.convertAddCategoryRequestToCategory(addCategoryRequest);
            categoryDao.save(category);

            return new SuccessResult("Category added");
        } else {
            return new ErrorResult("Category not added");
        }

    }

    @Override
    public DataResult<Category> getByCategoryId(int categoryId) {
        return new SuccessDataResult<Category>(
                this.categoryDao.getByCategoryId(categoryId));
    }


    @Override
    public DataResult<List<CategoryListDto>> getAll() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryListDto> categoryListDtoList = new ArrayList<>();

        for (Category category : categories) {
            CategoryListDto categoryListDto = new CategoryListDto();
            categoryListDto = this.convertAddCategoryListToCategory(category);

            categoryListDtoList.add(categoryListDto);
        }
        return new SuccessDataResult<List<CategoryListDto>>(categoryListDtoList, "Category listed");
    }


  //  @Override
    //public void delete() {
      //  categoryDao.deleteAll();
   // }

    private Category convertAddCategoryRequestToCategory(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();

        category.setCategoryName(addCategoryRequest.getCategoryName());
        category.setCategoryId(addCategoryRequest.getCategoryId());

        return category;
    }

    private boolean validateRequest(AddCategoryRequest addCategoryRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(addCategoryRequest.getCategoryName())) {
            isSuccess = false;

        }
        return isSuccess;
    }

    private CategoryListDto convertAddCategoryListToCategory(Category category) {
        CategoryListDto categoryListDto = new CategoryListDto();

        categoryListDto.setCategoryName(category.getCategoryName());
        categoryListDto.setCategoryId(category.getCategoryId());

        return categoryListDto;
    }




}
