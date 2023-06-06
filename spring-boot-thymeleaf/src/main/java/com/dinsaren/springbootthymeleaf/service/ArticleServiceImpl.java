package com.dinsaren.springbootthymeleaf.service;

import com.dinsaren.springbootthymeleaf.models.Article;
import com.dinsaren.springbootthymeleaf.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleServices
{
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAllData() {
       return articleRepository.findAllByStatus("ACT");
    }

    @Override
    public void create(Article req) {
        req.setStatus("ACT");
        articleRepository.save(req);
    }

    @Override
    public Article update(Integer id) {
        Article article=articleRepository.findById(id).get();
        return articleRepository.save(article);
    }

    @Override
    public void delete(Integer id) {
        Article article=null;
        article=articleRepository.getById(id);
        article.setStatus("DEL");
        articleRepository.delete(article);
    }

    @Override
    public Article getById(Integer id) {
       return articleRepository.findById(id).orElse(null);
    }
}
