package org.example.stationery;


public class Batch extends Article {

    private ArticleUnitary articleUnitary;

    private int quantity;

    private float discountPercentage;

    public Batch(ArticleUnitary articleUnitary, int quantity, float discountPercentage) {
        super();
        this.articleUnitary = articleUnitary;
        this.quantity = quantity;
        this.discountPercentage = discountPercentage;
    }

    public ArticleUnitary getArticleUnitary() {
        return articleUnitary;
    }

    public void setArticle(ArticleUnitary articleUnitary) {
        this.articleUnitary = articleUnitary;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "articleUnitary=" + articleUnitary +
                ", quantity=" + quantity +
                ", discountPercentage=" + discountPercentage +
                ", reference=" + reference +
                '}';
    }
}
