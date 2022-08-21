import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.*;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Книга первая", 100, "Автор1");
    Product product2 = new Smartphone(2, "Смартфон дешевый", 20_000, "Производитель2");
    Product product3 = new Book(3, "Книга третья", 300, "Автор3");
    Product product4 = new Smartphone(4, "Смартфон дорогой", 40_000, "Производитель4");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test
    public void shouldBeSearchProductBook() {

        Product[] expected = {product1, product3};

        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldBeSearchProductSmartPhone() {

        Product[] expected = {product2, product4};

        Product[] actual = manager.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldBeRemoveById() {

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.removeById(3);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldBeNewIdForBook() {

        product1.setId(5);

        int expected = 5;
        int actual = product1.getId();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldBeNewPriceForBook() {

        product1.setPrice(200);

        int expected = 200;
        int actual = product1.getPrice();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldBeNewNameForBook() {

        product1.setName("Книга5");

        String expected = "Книга5";
        String actual = product1.getName();

        Assertions.assertEquals(expected, actual);
    }


}
