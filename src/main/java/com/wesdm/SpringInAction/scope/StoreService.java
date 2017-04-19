package com.wesdm.SpringInAction.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //indicates singleton scope, created by container and last until context destroyed
public class StoreService {
	
	private ShoppingCart shoppingCart;

	//ShoppingCart bean will tried to be injected upon container startup, but won't exist until user creates session
	@Autowired
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
