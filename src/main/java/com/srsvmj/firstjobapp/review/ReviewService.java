package com.srsvmj.firstjobapp.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review getReview(Long companyId, Long reviewId);

    boolean addReview(Long companyId, Review review);

    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long reviewId);

}
