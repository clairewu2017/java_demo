package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
