package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/26.
 */
public class OrderedBook implements Serializable {
    private String isbn;

    private String title;

    private String author;

    private String press;

    private Float price;

    private String term;

    private static final long serialVersionUID = 1L;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "OrderedBook{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", price=" + price +
                ", term='" + term + '\'' +
                '}';
    }
}
