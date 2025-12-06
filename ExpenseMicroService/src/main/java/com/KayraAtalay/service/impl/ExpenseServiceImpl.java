package com.KayraAtalay.service.impl;

import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.enums.Category;
import com.KayraAtalay.manager.UserManager;
import com.KayraAtalay.model.Expense;
import com.KayraAtalay.repository.ExpenseRepository;
import com.KayraAtalay.service.IExpenseService;
import com.KayraAtalay.shared.exception.BaseException;
import com.KayraAtalay.shared.exception.ErrorMessage;
import com.KayraAtalay.shared.exception.MessageType;
import com.KayraAtalay.utils.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private Long getCurrentUserId() {
    return userManager.findUserIdByUsername().getPayload();
    }

    @Override
    public DtoExpense saveExpense(DtoExpenseIU expenseRequest) {
        Long userId = getCurrentUserId();
        Expense expense = Expense.builder()
                .amount(expenseRequest.getAmount())
                .description(expenseRequest.getDescription())
                .category(expenseRequest.getCategory())
                .userId(userId)
                .build();

        Expense savedExpense = expenseRepository.save(expense);

        return DtoConverter.toDto(savedExpense);
    }

    @Override
    public DtoExpense findExpenseById(Long expenseId) {
        Long userId = getCurrentUserId();

        Optional<Expense> optExpense = expenseRepository.FindByUserIdAndId(userId, expenseId);

        if (optExpense.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.EXPENSE_NOT_FOUND, expenseId.toString()));
        }

        return DtoConverter.toDto(optExpense.get());
    }

    @Override
    public Page<DtoExpense> findExpensesByUserId(Pageable pageable) {

        Long userId = getCurrentUserId();
       Page<Expense> expensePage = expenseRepository.findAllByUserId(userId, pageable);
       if(expensePage.isEmpty()){
           throw new BaseException(new ErrorMessage(MessageType.EXPENSE_NOT_FOUND, userId.toString()));
       }
       return expensePage.map(DtoConverter::toDto);
    }

    @Override
    public DtoExpense updateExpense(Long expenseId, DtoExpenseIU expenseRequest) {
        Long userId = getCurrentUserId();

        Optional<Expense> optExpense = expenseRepository.FindByUserIdAndId(userId, expenseId);

        if(optExpense.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.EXPENSE_NOT_FOUND, expenseId.toString()));
        }

        Expense expenseToUpdate = optExpense.get();
        expenseToUpdate.setAmount(expenseRequest.getAmount());
        expenseToUpdate.setDescription(expenseRequest.getDescription());
        expenseToUpdate.setCategory(expenseRequest.getCategory());
        expenseToUpdate.setUserId(userId);

        return DtoConverter.toDto(expenseRepository.save(expenseToUpdate));

    }

    @Override
    public Boolean deleteExpenseById(Long expenseId) {
        Long userId = getCurrentUserId();
        Optional<Expense> optExpense = expenseRepository.FindByUserIdAndId(userId, expenseId);
        if(optExpense.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.EXPENSE_NOT_FOUND, expenseId.toString()));
        }
        expenseRepository.deleteById(expenseId);

        return true;
    }

    @Override
    public List<DtoExpense> findAllExpensesByCategoryId(Category category) {
        Long userId = getCurrentUserId();
        List<Expense> expensesByCategory = expenseRepository.findAllByUserIdAndCategory(userId, category);

        if(expensesByCategory.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.EXPENSE_NOT_FOUND, category.toString()));
        }
        return expensesByCategory.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }


}


