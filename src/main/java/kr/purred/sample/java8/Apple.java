package kr.purred.sample.java8;

import lombok.Data;

/**
 * Created by purre on 2017-05-01.
 */
@Data
public class Apple
{
	private int weight;

	private String name;

	public Apple (int weight, String name)
	{
		this.weight = weight;
		this.name = name;
	}
}
