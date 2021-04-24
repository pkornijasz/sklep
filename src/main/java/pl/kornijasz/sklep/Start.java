package pl.kornijasz.sklep;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private final Basket basket;

    public Start(Basket basket) {
        this.basket = basket;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        basket.initProductList();
        while (true) {
            basket.showProductList();
            basket.addProduct();
        }
    }
}
