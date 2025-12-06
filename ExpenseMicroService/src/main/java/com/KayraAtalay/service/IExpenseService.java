package com.KayraAtalay.service;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IExpenseService {

    public DtoExpense saveExpense(DtoExpenseIU expense);

    public DtoExpense findExpenseById(Long expenseId);

    public Page<DtoExpense> findExpensesByUserId(Pageable pageable);

    public DtoExpense updateExpense(Long expenseId, DtoExpenseIU expense);

    public Boolean deleteExpenseById(Long expenseId);

    public List<DtoExpense> findAllExpensesByCategoryId(Category category);


}
