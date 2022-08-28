package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
        ProductRepository repo = new ProductRepository();

        Product product1 = new Book(1, "Книга первая", 100, "Автор1");
        Product product2 = new Smartphone(2, "Смартфон дешевый", 20_000, "Производитель2");
        Product product3 = new Book(3, "Книга третья", 300, "Автор3");

        @Test
        public void shouldSaveProduct() {
            repo.save(product1);
            repo.save(product2);
            repo.save(product3);

            Product[] expected = {product1, product2, product3};
            Product[] actual = repo.findAll();

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldRemoveProductById() {
            repo.save(product1);
            repo.save(product2);
            repo.save(product3);
            repo.removeById(2);

            Product[] expected = {product1, product3};
            Product[] actual = repo.findAll();

            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldThrowExcWhileRemovinNotExistinElement() {
            repo.save(product1);
            repo.save(product2);
            repo.save(product3);

            Assertions.assertThrows(NotFoundException.class, () -> {
                repo.removeById(100);
            });
        }

        @Test
        public void shouldFindById() {
            repo.save(product1);
            repo.save(product2);
            repo.save(product3);

            Product expected = product2;
            Product actual = repo.findById(2);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldNotFindById() {
            repo.save(product1);
            repo.save(product2);
            repo.save(product3);

            Product expected = null;
            Product actual = repo.findById(50);

            Assertions.assertEquals(expected, actual);
        }

}
