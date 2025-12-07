package com.KayraAtalay.config;

public class RestApis {

    public static final String DEVELOPER = "/dev";
    public static final String VERSIONS = "/v1";
    public static final String EXPENSE = DEVELOPER + VERSIONS + "/expense-tracker-expense";

    public static final String SAVE = "/save";
    public static final String FIND_EXPENSE_BY_ID = "/find-expense-by-id";
    public static final String FIND_EXPENSES_BY_USER_ID = "/find-expenses-by-user-id";
    public static final String UPDATE_EXPENSE = "/update-expense";
    public static final String DELETE_EXPENSE_BY_ID = "/delete-expense-by-id";
    public static final String FIND_EXPENSES_BY_CATEGORY = "/find-expenses-by-category";

}
