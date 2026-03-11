package com.library.dea.dto;

import com.library.dea.entity.Author;
import com.library.dea.validation.ValidPrice;
import jakarta.validation.constraints.*;

public class BookDTO {
    private Integer id;

    @Size(min = 2, max = 30, message = "Title must be 2-100 Characters")
    private String title;

    @Size(min = 4, max = 30, message = "Author must be 4-100 Characters")
    private String author;


    @Min(value = 1, message = "Amount must be at least 1")
    @Max(value = 5000, message = "Max amount must be not more 5000")
    private Integer amount;


//    @DecimalMin(value = "0.01", message = "Price must be at least 0.01")
//    @Digits(integer = 10, fraction = 2, message = "Price Format: up to 10 Digits and 2 decimals")
      @ValidPrice
      private Integer price;

      private Long authorId;

      private String authorName;


    public BookDTO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAuthorName() {return authorName;}

    public void setAuthorName(String authorName) {this.authorName = authorName;}

    public Long getAuthorId() {return authorId;}

    public void setAuthorId(Long authorId) {this.authorId = authorId;}
}
