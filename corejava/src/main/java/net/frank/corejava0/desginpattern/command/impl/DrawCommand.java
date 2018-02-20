package net.frank.corejava0.desginpattern.command.impl;

import java.awt.Point;

import net.frank.corejava0.desginpattern.command.define.Command;
import net.frank.corejava0.desginpattern.command.define.Drawable;

public class DrawCommand implements Command {

	protected Drawable drawable;
	
	private Point position;
	
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	
	@Override
	public void execute() {
		drawable.draw(position.x, position.y);
	}

}
