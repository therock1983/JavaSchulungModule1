
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
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  goedl
 * @version $Revision$
 */

public interface IPriceCalculator {
  public double calulcatePrice(List<OrderLine> orderLines); 
}
//---------------------------- Revision History ----------------------------
//$Log$
//
