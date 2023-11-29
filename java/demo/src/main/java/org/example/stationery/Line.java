package org.example.stationery;

public class Line {

    private Article article;
    private int quantity;
    private Double unitPrice;
    private Double priceTotal;

    public Line(ArticleUnitary articleUnitary, int quantity) {
        this.article = articleUnitary;
        this.quantity = quantity;
        this.unitPrice = articleUnitary.getPrice();
        this.priceTotal = calculatePriceTotal(unitPrice, quantity);
    }

    public Line(Batch batch, int quantity) {
        this.article = batch;
        this.quantity = quantity;
        this.unitPrice = batch.getArticleUnitary().getPrice() * (1 - batch.getDiscountPercentage() / 100);
        this.priceTotal = calculatePriceTotal(unitPrice, quantity);
    }

    private Double calculatePriceTotal(Double unitPrice, int quantity) {
        return unitPrice * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.priceTotal = calculatePriceTotal(unitPrice, quantity);
    }

    public Article getArticle() {
        return article;
    }


    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        this.priceTotal = calculatePriceTotal(unitPrice, quantity);
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Override
    public String toString() {
        return "Line{" +
                "article=" + article +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", priceTotal=" + priceTotal +
                '}';
    }
}
