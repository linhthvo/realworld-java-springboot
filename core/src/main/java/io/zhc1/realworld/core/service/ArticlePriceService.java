package io.zhc1.realworld.core.service;

import io.zhc1.realworld.core.model.Article;
import io.zhc1.realworld.core.model.ArticlePrice;
import io.zhc1.realworld.core.model.ArticlePriceRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class ArticlePriceService {
    private final ArticlePriceRepository articlePriceRepository;

    public ArticlePriceService(ArticlePriceRepository articlePriceRepository) {
        this.articlePriceRepository = articlePriceRepository;
    }

    public List<ArticlePrice> getAllArticlePrices() {
        return articlePriceRepository.findAll();
    }
}
