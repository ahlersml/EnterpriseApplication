package com.example.enterpriseapplication.dao;

import com.example.enterpriseapplication.dto.Recipe;

public interface IRecipeDAO {
    Recipe save(Recipe recipe) throws Exception;
}
