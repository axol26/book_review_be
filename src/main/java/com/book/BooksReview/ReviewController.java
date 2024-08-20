package com.book.BooksReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{bookId}")
    public Review getReviewByReviewId(@PathVariable String bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @PutMapping("/{bookId}")
    public Review updateReviewByReviewId(@PathVariable String bookId, @RequestBody Review review) {
        Review existingReview = reviewRepository.findByBookId(bookId);
        if (existingReview != null) {
            review.setId(existingReview.getId());
            return reviewRepository.save(review);
        }
        return null;
    }

    @DeleteMapping("/{bookId}")
    public void deleteReview(@PathVariable String bookId) {
        Review existingReview = reviewRepository.findByBookId(bookId);
        if (existingReview != null) {
            reviewRepository.delete(existingReview);
        }
    }
}
