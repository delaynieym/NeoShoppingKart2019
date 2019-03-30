package com.saintsrobotics.shoppingkart.config;

import com.github.dozer.input.OI.XboxInput;

public class OI {
	public XboxInput xboxInput = new XboxInput(0);
	public XboxInput meme = new XboxInput(2); // for testing neo motor for climber. if it's still here, delete all
												// instances of this
	public OperatorBoard oppInput = new OperatorBoard(1);

	public OI() {
		this.xboxInput.init();
		this.meme.init();
		this.oppInput.init();
	}
}
