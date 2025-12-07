package com.KayraAtalay.controller.impl;

import com.KayraAtalay.controller.IRestExpenseController;
import com.KayraAtalay.dto.request.DtoExpenseIU;
import com.KayraAtalay.dto.response.DtoExpense;
import com.KayraAtalay.enums.Category;
import com.KayraAtalay.service.IExpenseService;
import com.KayraAtalay.shared.response.RestBaseController;
import com.KayraAtalay.shared.response.RootEntity;
import com.KayraAtalay.shared.utils.PageableRequest;
import com.KayraAtalay.shared.utils.RestPageableEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.KayraAtalay.config.RestApis.*;

@RestController
@RequestMapping(EXPENSE)
@RequiredArgsConstructor
public class RestExpenseControllerImpl extends RestBaseController implements IRestExpenseController {
    private final IExpenseService expenseService;

    @PostMapping(SAVE)
    @Override
    public RootEntity<DtoExpense> saveExpense(@Valid @RequestBody DtoExpenseIU expenseRequest) {
        return ok(expenseService.saveExpense(expenseRequest));
    }

    @GetMapping(FIND_EXPENSE_BY_ID + "/{id}")
    @Override
    public RootEntity<DtoExpense> findExpenseById(@PathVariable Long id) {
        return ok(expenseService.findExpenseById(id));
    }

    @GetMapping(FIND_EXPENSES_BY_USER_ID)
    @Override
    public RootEntity<RestPageableEntity<DtoExpense>> findExpensesByUserId(PageableRequest pageableRequest) {

        Page<DtoExpense> page = expenseService.findExpensesByUserId(toPageable(pageableRequest));
        return ok(toPageableResponse(page, page.getContent()));
    }

    @PutMapping(UPDATE_EXPENSE + "/{expenseId}")
    @Override
    public RootEntity<DtoExpense> updateExpense(@PathVariable Long expenseId,@Valid @RequestBody DtoExpenseIU expenseRequest) {
        return ok(expenseService.updateExpense(expenseId, expenseRequest));
    }

    @DeleteMapping(DELETE_EXPENSE_BY_ID + "/{expenseId}")
    @Override
    public RootEntity<Boolean> deleteExpenseById(@PathVariable Long expenseId) {
        return ok(expenseService.deleteExpenseById(expenseId));
    }

    @GetMapping(FIND_EXPENSES_BY_CATEGORY)
    @Override
    public RootEntity<List<DtoExpense>> findExpensesByCategory(@RequestParam Category category) {
        return ok(expenseService.findAllExpensesByCategory(category));
    }
}
