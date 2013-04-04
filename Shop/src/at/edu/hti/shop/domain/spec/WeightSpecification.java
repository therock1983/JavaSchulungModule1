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

public class WeightSpecification extends AbstractSpecification {
  private final double maxWeight;
  private double currentWeight;

  public WeightSpecification(final double maxWeight) {
    this.maxWeight = maxWeight;
  }

  @Override
  public boolean isSatisfiedBy(OrderLine orderLine) {
    currentWeight += orderLine.calcWeight();
    if (currentWeight > maxWeight) {
      return false;
    }
    return true;
  }

  @Override
  public void reset() {
    currentWeight = 0;
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
