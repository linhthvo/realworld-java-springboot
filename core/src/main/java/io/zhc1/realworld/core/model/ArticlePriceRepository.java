package io.zhc1.realworld.core.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArticlePriceRepository extends JpaRepository<ArticlePrice, Long> {
}