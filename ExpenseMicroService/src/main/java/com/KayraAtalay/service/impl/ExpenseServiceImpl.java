package com.KayraAtalay.service.impl;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.manager.UserManager;
import com.KayraAtalay.model.Expense;
import com.KayraAtalay.repository.ExpenseRepository;
import com.KayraAtalay.service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserManager userManager;

    private Expense createExpense(DtoExpenseIU dtoExpenseIU, Long userId) {
        return Expense.builder()
                .amount(dtoExpenseIU.getAmount())
                .description(dtoExpenseIU.getDescription())
                .category(dtoExpenseIU.getCategory())
                .userId(userId)
                .build();
    }

    @Override
    public DtoExpense saveExpense(DtoExpenseIU expense) {
        return null;
    }

    @Override
    public DtoExpense findExpenseById(Long expenseId) {
        return null;
    }

    @Override
    public DtoExpense findExpensesByUserId(Long userId) {
        return null;
    }
}


