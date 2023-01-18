package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.CategoryService;
import Shopping.ETrade.business.abstracts.ProductService;
import Shopping.ETrade.business.dtos.CategoryListDto;
import Shopping.ETrade.business.dtos.ProductListDto;
import Shopping.ETrade.business.request.AddProductRequest;
import Shopping.ETrade.dataaccess.abstracts.ProductsDao;
import Shopping.ETrade.entities.concretes.Category;
import Shopping.ETrade.entities.concretes.Product;
import Shopping.ETrade.result.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductsDao productsDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ProductManager(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public DataResult<List<ProductListDto>> getAll() {
        List<Product> products = productsDao.findAll();
        List<ProductListDto> productListDtoList = new ArrayList<>();

        for (Product product : products) {
            ProductListDto productListDto = new ProductListDto();
            productListDto = this.convertProductToProductListDto(product);

            productListDtoList.add(productListDto);
        }
        return new SuccessDataResult<List<ProductListDto>>(productListDtoList, "Products listed");
    }

    @Override
    public Result add(AddProductRequest addProductRequest) {
        if (this.validateRequest(addProductRequest)) {
            Product product = this.convertAddProductRequestToProduct(addProductRequest);
            productsDao.save(product);

            return new SuccessResult("Product added");
        } else {
            return new ErrorResult("Product not added");
        }
    }

    @Override
    public DataResult<Product> getByCategoryId(int categoryId) {
        return new SuccessDataResult<Product>
                (this.productsDao.getByProductId(categoryId));

    }

    @Override
    public void deleteById(int productId) {
        this.productsDao.deleteById(productId);
    }


    private Product convertAddProductRequestToProduct(AddProductRequest addProductRequest) {
        Product product = new Product();

        product.setProductName(addProductRequest.getProductName());
        product.setProductColor(addProductRequest.getProductColor());
        product.setProductPrice(addProductRequest.getProductPrice());
        product.setUnitInStock(addProductRequest.getUnitInStock());

        Category category = categoryService.getByCategoryId(addProductRequest.getCategoryId()).getData();
        product.setCategory(category);

        return product;
    }

    private boolean validateRequest(AddProductRequest addProductRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(addProductRequest.getProductName())) {
            isSuccess = false;

        }
        return isSuccess;
    }

    private ProductListDto convertProductToProductListDto(Product product) {
        ProductListDto productListDto = new ProductListDto();

        productListDto.setProductName(product.getProductName());
        productListDto.setProductColor(product.getProductColor());
        productListDto.setProductPrice(product.getProductPrice());
        productListDto.setUnitInStock(product.getUnitInStock());
        productListDto.setCategoryName(product.getCategory().getCategoryName());

        return productListDto;
    }

  /*  @Override
    public void delete() {
        productsDao.deleteAll();
   */}


//}
