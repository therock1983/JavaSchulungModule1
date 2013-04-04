/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package at.edu.hti.shop.domain.price;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author goedl
 * @version $Revision$
 */

public class DefaultPriceStrategy implements IPriceCalculator {

  @Override
  public double calulcatePrice(List<OrderLine> orderLines) {
    double sum = 0;
    for (OrderLine line : orderLines) {
      sum += line.calcPrize();
    }
    if (sum < 10) {
      sum += 5;
    }
    return sum;
  }

}
//---------------------------- Revision History ----------------------------
//$Log$
//