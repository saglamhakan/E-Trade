package Shopping.ETrade.business.concretes;

import Shopping.ETrade.business.abstracts.ProductService;
import Shopping.ETrade.core.result.DataResult;
import Shopping.ETrade.core.result.Result;
import Shopping.ETrade.core.result.SuccessDataResult;
import Shopping.ETrade.core.result.SuccessResult;
import Shopping.ETrade.dataaccess.abstracts.ProductsDao;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductsDao productsDao;

    @Autowired
    public ProductManager(ProductsDao productsDao){
        this.productsDao=productsDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productsDao.findAll(), "Data listed");
    }


    @Override
    public Result add(Product product) {
        this.productsDao.save(product);
        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> getByCategoryId(int categoryId) {
        this.productsDao.getByProductId(categoryId);
        return null;

    }








}
