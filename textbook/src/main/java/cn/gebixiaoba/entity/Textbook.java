package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * T_Textbook
 * @author 
 */
public class Textbook implements Serializable {
    private String isbn;

    private String title;

    private String author;

    private String press;

    private Float price;

    private Integer total;

    private static final long serialVersionUID = 1L;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Textbook other = (Textbook) that;
        return (this.getIsbn() == null ? other.getIsbn() == null : this.getIsbn().equals(other.getIsbn()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getPress() == null ? other.getPress() == null : this.getPress().equals(other.getPress()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIsbn() == null) ? 0 : getIsbn().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getPress() == null) ? 0 : getPress().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", isbn=").append(isbn);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", press=").append(press);
        sb.append(", price=").append(price);
        sb.append(", total=").append(total);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}