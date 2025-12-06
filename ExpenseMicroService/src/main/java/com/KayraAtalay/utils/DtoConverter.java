package com.KayraAtalay.utils;

import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.model.Expense;

public class DtoConverter {

    public static DtoExpense toDto(Expense expense) {
        return DtoExpense.builder()
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .category(expense.getCategory())
                .userId(expense.getUserId())
                .id(expense.getId())
                .createTime(expense.getCreateTime())
                .build();

    }

}
