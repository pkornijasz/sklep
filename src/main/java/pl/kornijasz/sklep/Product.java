package pl.kornijasz.sklep;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + "\tCena: " + price + " zł";
    }
}
