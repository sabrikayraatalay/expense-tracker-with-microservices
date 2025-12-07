package com.KayraAtalay.controller;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.enums.Category;
import com.KayraAtalay.shared.response.RootEntity;
import com.KayraAtalay.shared.utils.PageableRequest;
import com.KayraAtalay.shared.utils.RestPageableEntity;

import java.util.List;

public interface IRestExpenseController {

    public RootEntity<DtoExpense> saveExpense(DtoExpenseIU expenseRequest);

    public RootEntity<DtoExpense> findExpenseById(Long id);

    public RootEntity<RestPageableEntity<DtoExpense>> findExpensesByUserId(PageableRequest pageableRequest);

    public RootEntity<DtoExpense> updateExpense(Long expenseId, DtoExpenseIU expenseRequest);

    public RootEntity<Boolean> deleteExpenseById(Long expenseId);

    public RootEntity<List<DtoExpense>> findExpensesByCategory(Category  category);

}
