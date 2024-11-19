package com.srsvmj.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
        //. To Retrieve all the Reviews
        //URL: http://localhost:8080/companies/1/reviews

        @GetMapping("/reviews")
        public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {

            return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
        }

        //2. To Retrieve Review By ID
        @GetMapping("/reviews/{reviewId}")
        public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId) {
            return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
        }

        //3. Create new Review
        @PostMapping("/reviews")
        public ResponseEntity<String> addReview (Long companyId, @RequestBody Review review){

            boolean isReviewSaved = reviewService.addReview(companyId, review);

            if (isReviewSaved)
                return new ResponseEntity<>("Review Created Successfully", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("Review Not Created", HttpStatus.NOT_FOUND);
        }

        //4. To Update the Review
        @PutMapping("/reviews/{reviewId}")
        public ResponseEntity<String> updateReview (@PathVariable Long companyId,
                                                    @PathVariable Long reviewId,
                                                    @RequestBody Review review){

            boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId,review);

            if (isReviewUpdated)
                return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
        }

        //4. To Delete an Review By ID
        @DeleteMapping("/reviews/{reviewId}")
        public ResponseEntity<String> deleteReview (@PathVariable Long reviewId){

            boolean isReviewDeleted = reviewService.deleteReview(reviewId);

            if (isReviewDeleted)
                return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
        }

}