package com.example.demo.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class Zoo
{
	@Autowired
	private Tiger tiger;

	@Autowired
	private Monkey monkey;

	@Override
	public String toString()
	{
		return tiger + "\n" + monkey;
	}
}
