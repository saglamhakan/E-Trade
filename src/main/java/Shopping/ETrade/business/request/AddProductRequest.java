package Shopping.ETrade.business.request;

import Shopping.ETrade.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {


    private String productName;

    private int productPrice;

    private int unitInStock;

    private String productColor;

    private int categoryId;
}
