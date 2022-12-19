package com.pyyh.inoutbound.service;

public interface ICommunicationFactory<P, T> {

	public T openChannel(P p);
}
