package com.customer.manage.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.manage.entity.CustomerEntity;
import com.customer.manage.exception.CustomerNotFound;
import com.customer.manage.mapper.CustomerEntityMapper;
import com.customer.manage.mapper.CustomerModelMapper;
import com.customer.manage.model.CustomerModel;
import com.customer.manage.repository.CustomerDao;
import com.customer.manage.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerEntityMapper customerEntityMapper;
	
	@Autowired
	private CustomerModelMapper customerModelMapper;


	@Override
	public void createCustomer(CustomerModel customerModel) {
		customerDao.save(customerEntityMapper.modelToCustomerEntity(customerModel));
	}

	@Override
	public void updateCustomer(CustomerModel customerModel) {
		customerDao.save(customerEntityMapper.modelToCustomerEntity(customerModel));
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteById(customerId);
	}

	@Override
	public CustomerModel findByCustomerId(int customerId) {
		CustomerModel customerModel;
		Optional<CustomerEntity> customerModelOptional = customerDao.findById(customerId);
		if(customerModelOptional.isPresent()) {
			customerModel = customerModelMapper.entityToCustomerModel(customerModelOptional.get());
		}else {
			throw new CustomerNotFound("Customer not found for giver customerId--->" + customerId);
		}
		return customerModel;
		
	}

}
