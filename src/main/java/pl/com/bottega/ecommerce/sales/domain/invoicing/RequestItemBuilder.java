package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductDataBuilder;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import pl.com.bottega.ecommerce.sharedkernel.MoneyBuilder;

public class RequestItemBuilder {

    private ProductData productData;

	private int quantity = 1;

	private Money totalCost;

    RequestItemBuilder()
    {
        ProductDataBuilder productDataBuilder = new ProductDataBuilder();
        productData = productDataBuilder.generateDefaultProductDataBuilder().build();

        MoneyBuilder moneyBuilder = new MoneyBuilder();
        totalCost = moneyBuilder.build();
    }

    public RequestItemBuilder withProductData(ProductData productData)
    {
        this.productData = productData;
        return this;
    }

    public RequestItemBuilder withQuantity(int quantity)
    {
        this.quantity = quantity;
        return this;
    }

    public RequestItemBuilder withTotalCost(Money totalCost)
    {
        this.totalCost = totalCost;
        return this;
    }

    public RequestItem build() {
        return new RequestItem(productData, quantity, totalCost);
    }
    
}
