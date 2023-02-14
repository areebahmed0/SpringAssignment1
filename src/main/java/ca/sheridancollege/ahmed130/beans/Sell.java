package ca.sheridancollege.ahmed130.beans;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sell {
	
	private String itemName;
	private String itemDesc;
	private double itemPrice;
	private String itemColor;
}
