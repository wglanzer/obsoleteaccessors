package de.adito.aditoweb.obsoleteAccessors.impl.version;

import de.adito.aditoweb.obsoleteAccessors.impl.attributes.IAccessorAttributeDescription;
import de.adito.aditoweb.obsoleteAccessors.impl.attributes.conversion.IAccessorAttributeConverter;

import java.util.*;

/**
 * @author W.Glanzer, 08.09.2017
 */
abstract class AbstractAccessorVersion implements IAccessorVersion
{

  private final int version;
  private final String pkgName;
  private final String id;
  private final Class<?> type;
  private final List<IAccessorAttributeDescription<?>> attributeDescriptions;

  public AbstractAccessorVersion(int pVersion, String pPkgName, String pID, Class<?> pType, List<IAccessorAttributeDescription<?>> pAttributeDescriptions)
  {
    version = pVersion;
    pkgName = pPkgName;
    id = pID;
    type = pType;
    attributeDescriptions = pAttributeDescriptions == null ? Collections.emptyList() : pAttributeDescriptions;
  }

  @Override
  public int getVersion()
  {
    return version;
  }

  @Override
  public String getPkgName()
  {
    return pkgName;
  }

  @Override
  public String getId()
  {
    return id;
  }

  @Override
  public Class<?> getType()
  {
    return type;
  }

  @Override
  public List<IAccessorAttributeDescription<?>> getAttributeDescriptions()
  {
    return attributeDescriptions;
  }

  @Override
  public IAccessorAttributeConverter getConverter()
  {
    return null;
  }
}
