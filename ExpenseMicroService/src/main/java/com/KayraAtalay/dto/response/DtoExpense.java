package com.KayraAtalay.dto.response;

import com.KayraAtalay.enums.Category;
import com.KayraAtalay.shared.dto.DtoBase;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DtoExpense extends DtoBase {

    private Long userId;

    private BigDecimal amount;

    private String description;

    private Category category;

}
