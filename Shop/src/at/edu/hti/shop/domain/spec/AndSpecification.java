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

public class AndSpecification extends AbstractSpecification {
  private final ISpecification left;
  private final ISpecification right;

  public AndSpecification(final ISpecification left, final ISpecification right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean isSatisfiedBy(OrderLine orderLine) {
    return left.isSatisfiedBy(orderLine) && right.isSatisfiedBy(orderLine);
  }
  
  @Override
  public void reset() {
    left.reset();
    right.reset();
  }
}
//---------------------------- Revision History ----------------------------
//$Log$
//
