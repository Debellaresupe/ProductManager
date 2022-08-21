package ru.netology.product;

public class Book extends Product {

    public String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
