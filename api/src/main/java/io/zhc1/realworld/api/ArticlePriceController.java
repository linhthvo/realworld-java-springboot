package io.zhc1.realworld.api;

import io.zhc1.realworld.core.model.ArticlePrice;
import io.zhc1.realworld.core.service.ArticlePriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticlePriceController {
    private final ArticlePriceService articlePriceService;

    public ArticlePriceController(ArticlePriceService articlePriceService) {
        this.articlePriceService = articlePriceService;
    }

    // Endpoint to retrieve all article prices
    @GetMapping("/article-prices")
    public List<ArticlePrice> getAllArticlePrices() {
        return articlePriceService.getAllArticlePrices();
    }
}
