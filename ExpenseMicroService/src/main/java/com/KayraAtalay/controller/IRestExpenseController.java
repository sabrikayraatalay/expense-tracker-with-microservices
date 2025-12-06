package com.KayraAtalay.controller;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.shared.response.RootEntity;

import java.util.List;

public interface IRestExpenseController {
    public RootEntity<DtoExpense> findById(Long id);
    public RootEntity<DtoExpense> saveExpense(DtoExpenseIU expenseRequest);
    public RootEntity<List<DtoExpense>> findExpensesByUserId(DtoExpense expenseRequest);

}
