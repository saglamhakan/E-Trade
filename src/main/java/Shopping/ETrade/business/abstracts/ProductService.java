package Shopping.ETrade.business.abstracts;

import Shopping.ETrade.business.dtos.ProductListDto;
import Shopping.ETrade.business.request.AddProductRequest;
import Shopping.ETrade.result.DataResult;
import Shopping.ETrade.result.Result;
import Shopping.ETrade.entities.concretes.Product;

import java.util.List;


public interface ProductService {
    DataResult<List<ProductListDto>> getAll();
    Result add (AddProductRequest addProductRequest);
    DataResult<Product> getByCategoryId(int categoryId);

   // void delete();
}
