package com.coderscampus.Assignment9DavidLobo.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.List; 

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9DavidLobo.domain.Recipe;
import com.coderscampus.Assignment9DavidLobo.repository.RecipeRepository;

@Service
public class FileService {
	@Autowired
	private RecipeRepository repositoryRecipe;
	
	private List<Recipe> readIntoFile()  {
	
		CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(',')
				.withEscape('\\')
				.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
				.withSkipHeaderRecord()
				.withIgnoreSurroundingSpaces();
		
	
	
	
	try (Reader in = new FileReader("recipe.txt")) {
		Iterable<CSVRecord> records = csvFormat.parse(in);
		
		for (CSVRecord record : records) {
	    	
		    Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
		    Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
		    Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
		    String instructions = record.get("Instructions");
		    Double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
		    Double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
		    Integer readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
		    Integer servings = Integer.parseInt(record.get("Servings"));
		    Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
		    String title = record.get("Title");
		    Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
		    Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
		    
		    Recipe recipe = new Recipe();
		    recipe.setCookingMinutes(cookingMinutes);
		    recipe.setDairyFree(dairyFree);
		    recipe.setGlutenFree(glutenFree);
		    recipe.setInstructions(instructions);
		    recipe.setPreparationMinutes(preparationMinutes);
		    recipe.setPricePerServing(pricePerServing);
		    recipe.setReadyInMinutes(readyInMinutes);
		    recipe.setServings(servings);
		    recipe.setSpoonacularScore(spoonacularScore);
		    recipe.setTitle(title);
		    recipe.setVegan(vegan);
		    recipe.setVegetarian(vegetarian);
		    
		    repositoryRecipe.getRecipeArray().add(recipe);
		}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return repositoryRecipe.getRecipeArray();
	}
	
	
	public List<Recipe> getAllRecipes ()  {
		if(repositoryRecipe.getRecipeArray().size() == 0) {
			return readIntoFile();
		}
		return repositoryRecipe.getRecipeArray();
	}
	
}
