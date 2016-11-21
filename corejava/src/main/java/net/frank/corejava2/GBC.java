package net.frank.corejava2;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888727307737018859L;

	// 初始化左上角位置
	public GBC(int gridX, int gridY) {
		this.gridx = gridX;
		this.gridy = gridY;
	}

	// 初始化左上角位置和所占行数和列数
	public GBC(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
	}

	// 对齐方式
	public GBC setAnchor(int anchor) {
		this.anchor = anchor;
		return this;
	}

	// 是否拉伸及拉伸方向
	public GBC setFill(int fill) {
		this.fill = fill;
		return this;
	}

	// x和y方向上的增量
	public GBC setWeight(double weightX, double weightY) {
		this.weightx = weightX;
		this.weighty = weightY;
		return this;
	}

	// 外填充（等距）
	public GBC setInsets(int distance) {
		this.insets = new Insets(distance, distance, distance, distance);
		return this;
	}

	// 外填充
	public GBC setInsets(int top, int left, int bottom, int right) {
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}

	// 内填充
	public GBC setIpad(int ipadX, int ipadY) {
		this.ipadx = ipadX;
		this.ipady = ipadY;
		return this;
	}

}
