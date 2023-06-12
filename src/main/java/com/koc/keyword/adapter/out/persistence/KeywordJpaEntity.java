package com.koc.keyword.adapter.out.persistence;

import com.koc.keyword.domain.KeywordType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "keyword", indexes = {
        @Index(name = "Keyword_Text_Index", columnList = "text", unique = true)
})
@EntityListeners(AuditingEntityListener.class)
class KeywordJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private KeywordType type;
    private String text;
    private Long count;

    @CreatedBy
    String createdBy;
    @CreatedDate
    LocalDateTime createdAt;
    @LastModifiedBy
    String updatedBy;
    @LastModifiedDate
    LocalDateTime updatedAt;

    public void increaseCount() {
        count += 1;
    }

    public static KeywordJpaEntity of(KeywordType type, String text) {
        KeywordJpaEntity entity = new KeywordJpaEntity();
        entity.type = type;
        entity.text = text;
        entity.count = 0L;
        return entity;
    }
}
