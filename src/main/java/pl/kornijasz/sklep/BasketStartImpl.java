package pl.kornijasz.sklep;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

@Service
@Profile("Start")
public class BasketStartImpl implements Basket {
    private final List<Product> productList;

    private BigDecimal genRandomPrice() {
        Random randomPrice = new Random();
        return new BigDecimal(randomPrice.nextDouble() * 250 + 50).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BasketStartImpl(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void initProductList() {
        productList.add(new Product("Procesor i5-11400F", genRandomPrice()));
        productList.add(new Product("Płyta główna Z590", genRandomPrice()));
        productList.add(new Product("Pamieć 2x32GB DDR4 ", genRandomPrice()));
        productList.add(new Product("Dysk SSD 1TB Gen4x4", genRandomPrice()));
        productList.add(new Product("Karta RTX3060 12GB", genRandomPrice()));
    }

    @Override
    public void addProduct() {
        System.out.println("Podaj nazwę produktu: ");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        System.out.println("Podaj cenę produktu: ");
        String price = scanner.nextLine();
        productList.add(new Product(item, new BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN)));
    }

    @Override
    public void showProductList() {
        System.out.println("Lista produktów w koszyku:");
        productList.forEach(System.out::println);
        Optional<BigDecimal> totalPrice = productList.stream().map(Product::getPrice).reduce(BigDecimal::add);
        System.out.println("Wartość wszystkich produktów:\t" + totalPrice.get() + " zł");
    }
}
