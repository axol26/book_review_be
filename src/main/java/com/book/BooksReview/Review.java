package com.book.BooksReview;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "reviews")
@Data
public class Review {
    @Id
    private String id;
    private String bookId;
    private List<String> reviews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
