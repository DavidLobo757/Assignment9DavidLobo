package com.coderscampus.Assignment9DavidLobo.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9DavidLobo.domain.Recipe;
import com.coderscampus.Assignment9DavidLobo.service.FileService;

@RestController
public class FileController {
	@Autowired
	private FileService fileService;
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() {
		return fileService.getAllRecipes()
						  .stream()
						  .filter(Recipe::getGlutenFree)
						  .collect(Collectors.toList());
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		return fileService.getAllRecipes().stream().filter(Recipe::getVegan).collect(Collectors.toList());
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGluenFree() throws IOException {
		return fileService.getAllRecipes().stream().filter(recipe -> recipe.getVegan() && recipe.getGlutenFree()).collect(Collectors.toList());
	}
	
	@GetMapping("vegetarian")
	public List<Recipe> getVegetarian() {
		return fileService.getAllRecipes().stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
	}
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() {
		return fileService.getAllRecipes();
	}
	
}
