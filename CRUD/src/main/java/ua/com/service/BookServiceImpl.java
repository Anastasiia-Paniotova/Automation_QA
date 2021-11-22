package ua.com.service;

import ua.com.dao.BookDao;
import ua.com.dao.BookDaoImpl;
import ua.com.entity.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final BookDao customerDao = new BookDaoImpl();

    @Override
    public void create(Customer customer) {
        if (!customerDao.existByEmail(customer.getEmail())) {
            customerDao.create(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(String id) {
        customerDao.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}