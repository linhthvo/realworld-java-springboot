package io.zhc1.realworld.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articleprice")
public class ArticlePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int priceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
    private String type;
    private double price;

    public ArticlePrice() {
    }

    public ArticlePrice(Article article, String type, double price) {
        this.article = article;
        this.type = type;
        this.price = price;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
