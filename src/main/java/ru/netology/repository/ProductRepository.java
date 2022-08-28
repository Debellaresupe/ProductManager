package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] productRepositories = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[productRepositories.length +1];
        for (int i = 0; i < productRepositories.length; i++) {
            tmp[i] = productRepositories[i];
        }
        tmp[tmp.length - 1] = product;
        productRepositories = tmp;
    }

    public Product[] findAll() {
        return productRepositories;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[productRepositories.length - 1];
        int copyToIndex = 0;
        for (Product product : productRepositories) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            productRepositories = tmp;
        }
        return productRepositories;
    }
    public Product findById(int id) {
        for (Product product : productRepositories) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
