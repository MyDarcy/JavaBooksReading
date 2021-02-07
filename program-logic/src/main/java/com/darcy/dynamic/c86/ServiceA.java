package com.darcy.dynamic.c86;

import com.darcy.dynamic.c85.SimpleInject;

public class ServiceA {

	@SimpleInject
	ServiceB b;
	
	public void callB(){
		b.action();
	}

	public ServiceB getB() {
		return b;
	}
	
	
}
