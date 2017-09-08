package de.adito.aditoweb.obsoleteAccessors.impl;

import de.adito.aditoweb.obsoleteAccessors.api.Function;
import org.jetbrains.annotations.Nullable;

/**
 * @author W.Glanzer, 04.09.2017
 */
public class FunctionConverterAccessor
{

  private static FunctionConverterAccessor _INSTANCE;

  public static FunctionConverterAccessor getInstance()
  {
    if(_INSTANCE == null)
      _INSTANCE = new FunctionConverterAccessor();
    return _INSTANCE;
  }

  @Nullable
  public Function convert(Function pOldFunction, @Nullable String pCategory)
  {
    return ConvertableRegistry.getInstance().find(pCategory, pOldFunction.getPackageName(), pOldFunction);
  }

}
