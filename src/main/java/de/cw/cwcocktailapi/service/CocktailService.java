package de.cw.cwcocktailapi.service;

import org.springframework.stereotype.Service;

@Service
public class CocktailService {

/*  @Autowired
  private CocktailDao cocktailDao;

  @Autowired
  private IngredientService ingredientService;

  @Autowired
  private ImageService imageService;

  private void getAndSetCocktailIngredients(List<Cocktail> cocktails,
      List<Ingredient> ingredients) {
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        for (Ingredient ingredient : ingredients) {
          if (cocktailIngredient.getIngredient_id().equals(ingredient.getId())) {
            cocktailIngredient.setIngredient(ingredient);
            break;
          }
        }
      }
    }
  }

  private void getAndSetAlternativeCocktailIngredients(List<Cocktail> cocktails,
      List<Ingredient> ingredients) {
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        cocktailIngredient.setAlternativeIngredients(ingredients.stream().filter(ingredient ->
            !cocktailIngredient.getIngredient().getId().equals(ingredient.getId()) && ingredient
                .getCategories().containsAll(cocktailIngredient.getIngredient().getCategories())
        ).collect(Collectors.toList()));
      }
    }
  }

  private List<Cocktail> filterCocktailsByCategories(List<Cocktail> cocktails,
      List<IngredientCategory> filterCategories, Integer missingCategories) {
    if (filterCategories != null && !filterCategories.isEmpty()) {
      Set<Cocktail> filteredCocktails = new HashSet<>();
      for (Cocktail cocktail : cocktails) {
        int countFitCategories = 0;
        for (CocktailIngredient ingredient : cocktail.getIngredients()) {
          for (IngredientCategory category : ingredient.getIngredient().getCategories()) {
            for (IngredientCategory filterCategory : filterCategories) {
              if (filterCategory.equals(category)) {
                countFitCategories += 1;
              }
            }
          }
        }
        if (countFitCategories >= filterCategories.size() - missingCategories) {
          filteredCocktails.add(cocktail);
        }
      }
      return new ArrayList<>(filteredCocktails);
    } else {
      return cocktails;
    }
  }

  private List<Cocktail> sort(List<Cocktail> cocktails) {
    cocktails.sort(new CocktailComparator());
    return cocktails;
  }

  public List<Cocktail> getCocktails(List<IngredientCategory> categories,
      Integer missingCategories) throws IOException {
    return sort(filterCocktailsByCategories(getCocktails(), categories, missingCategories));
  }

  private void getAndSetImageUrls(List<Cocktail> cocktails) {
    for (Cocktail cocktail : cocktails) {
      cocktail.setImageUrl(imageService.getUrl(cocktail.getName()));
    }
  }

  private List<Cocktail> getCocktails() throws IOException {
    List<Cocktail> cocktails = cocktailDao.getCocktails();
    List<Ingredient> ingredients = ingredientService.getIngredients();
    getAndSetCocktailIngredients(cocktails, ingredients);
    getAndSetAlternativeCocktailIngredients(cocktails, ingredients);
    return cocktails;
  }

  public Cocktail getCocktail(Long cocktailId) throws IOException {
    List<Cocktail> cocktails = getCocktails();
    for (Cocktail cocktail : cocktails) {
      if (cocktail.getId().equals(cocktailId)) {
        return cocktail;
      }
    }
    throw new ResourceNotFoundException();
  }*/

}
