package com.itss.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itss.parking.entity.Client;
import com.itss.parking.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {

	@Autowired
	public ClientServiceImpl(ClientRepository _repository) {
		super(_repository);
	}

}
