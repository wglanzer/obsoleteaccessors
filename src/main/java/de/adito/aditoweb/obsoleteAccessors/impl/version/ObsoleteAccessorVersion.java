package de.adito.aditoweb.obsoleteAccessors.impl.version;

import de.adito.aditoweb.obsoleteAccessors.impl.attrConv.*;
import de.adito.aditoweb.obsoleteAccessors.impl.attrDescr.IAccessorAttributeDescription;
import de.adito.aditoweb.obsoleteAccessors.spi.IAttributeConverter;

import java.util.List;

/**
 * @author W.Glanzer, 04.09.2017
 */
class ObsoleteAccessorVersion extends AbstractAccessorVersion
{

  private final Class<? extends IAttributeConverter> converter;

  public ObsoleteAccessorVersion(int pVersion, String pPkgName, String pId, Class<? extends IAttributeConverter> pConverter, Class<?> pType, List<IAccessorAttributeDescription<?>> pAttributeDescriptions)
  {
    super(pVersion, pPkgName, pId, pType, pAttributeDescriptions);
    converter = pConverter;
  }

  @Override
  public IAccessorAttributeConverter getConverter()
  {
    try
    {
      IAttributeConverter paramConv = converter.newInstance();
      return new ParameterAttributeConverter(paramConv);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }

}
