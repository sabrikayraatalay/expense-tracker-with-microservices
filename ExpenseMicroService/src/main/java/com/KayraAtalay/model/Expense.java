package com.KayraAtalay.model;

import com.KayraAtalay.enums.Category;
import com.KayraAtalay.shared.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense extends BaseEntity {

    @Column
    private Long userId;

    @Column
    private String description;

    @Column
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

}
