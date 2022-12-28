package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.core.result.DataResult;
import Shopping.ETrade.core.result.Result;
import Shopping.ETrade.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add (Product product);
    DataResult<Product> getByCategoryId(int categoryId);
}
