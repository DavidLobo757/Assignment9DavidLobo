package com.coderscampus.Assignment9DavidLobo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment9DavidLobo.domain.Recipe;

@Repository
public class RecipeRepository {
	private List<Recipe> recipeArray = new ArrayList<>(1000);
		
	public List<Recipe> getRecipeArray() {
			return recipeArray;
	}
}
