package com.github.wglanzer.obsoleteaccessors;

import com.github.wglanzer.obsoleteaccessors.api.*;
import com.github.wglanzer.obsoleteaccessors.spi.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author W.Glanzer, 11.09.2017
 */
@SuppressWarnings("unused")
@ObsoleteVersionContainer(category = "js", pkgName = "container", serialize = true)
public class TestVersionContainerImpl
{
  @ObsoleteVersions({
      @ObsoleteVersion(version = 0, id = "CLASSIFICATION_PRIVATE", type = int.class)
  })
  public final static String CLASSIFICATION_PUBLIC = "asdf";

  @ObsoleteVersions({
      @ObsoleteVersion(version = 0, id = "CLASSIFICATION_PRIVATE", type = String.class)
  })
  public final static String CLASSIFICATION_PUBLIC_STRING = "asdf";

  @ObsoleteVersions({
      @ObsoleteVersion(version = 0, pkgName = "obso", id = "getDoubleArr", type = double[].class),
      @ObsoleteVersion(version = 1, id = "getIntList", parameters = {double.class, int[].class}, converter = _IntListToIntArrayConverter.class)
  })
  public int[] getIntArray(String pParam)
  {
    return new int[0];
  }

  public static class _IntListToIntArrayConverter implements IAttributeConverter
  {
    @NotNull
    @Override
    public List<OAAttribute> convert(@NotNull List<OAAttribute> pAttributes) throws AttributeConversionException
    {
      return Collections.singletonList(new OAAttribute(String.class, String.valueOf(pAttributes.get(0).getValue())));
    }
  }

}