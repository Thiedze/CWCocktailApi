package de.cw.cwcocktailapi.controller.v1.mapper;

import java.util.List;

public interface CwCocktailApiMapper<T, S> {

  T convert(S object);

  List<T> convert(List<S> list);

}
