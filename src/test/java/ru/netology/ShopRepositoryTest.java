package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test
    public void testRemoveExistingElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 500);
        Product product2 = new Product(2, "Product2", 500);
        Product product3 = new Product(3, "Product3", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(1);

        Product[] products = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, products);
    }

    @Test
    public void testRemoveNonExistingElement() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Product1", 500);
        Product product2 = new Product(2, "Product2", 500);
        Product product3 = new Product(3, "Product3", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });

    }
}
