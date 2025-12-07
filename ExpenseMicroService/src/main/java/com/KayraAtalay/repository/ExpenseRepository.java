package com.KayraAtalay.repository;

import com.KayraAtalay.enums.Category;
import com.KayraAtalay.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public Optional<Expense> findByUserIdAndId(Long userId, Long id);
    public List<Expense> findAllByUserIdAndCategory(Long userId, Category category);
    public Page<Expense> findAllByUserId(Long userId, Pageable pageable);

}
