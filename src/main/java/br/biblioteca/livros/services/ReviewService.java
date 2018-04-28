package br.biblioteca.livros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public Iterable<Review> listaReviews() {
		return reviewRepository.findAll();
	}
}
