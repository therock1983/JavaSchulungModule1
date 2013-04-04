/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.OrderLine;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author goedl
 * @version $Revision$
 */

public interface ISpecification {
  public boolean isSatisfiedBy(OrderLine orderLine);

  public ISpecification or(ISpecification specification);

  public ISpecification and(ISpecification specification);
  
  public void reset();

}

//---------------------------- Revision History ----------------------------
//$Log$
//
