package com.KayraAtalay.service;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;


public interface IExpenseService {

    public DtoExpense saveExpense(DtoExpenseIU expense);
    public DtoExpense findExpenseById(Long expenseId);
    public DtoExpense findExpensesByUserId(Long userId);


}
