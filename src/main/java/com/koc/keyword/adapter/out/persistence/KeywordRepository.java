package com.koc.keyword.adapter.out.persistence;

import com.koc.keyword.domain.KeywordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface KeywordRepository extends JpaRepository<KeywordJpaEntity, Long> {
    Optional<KeywordJpaEntity> findByTypeAndText(KeywordType type, String text);

}
