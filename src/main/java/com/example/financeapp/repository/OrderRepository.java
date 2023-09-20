package com.example.financeapp.repository;

import com.example.financeapp.model.Loan;
import com.example.financeapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Loan getOrdersByOrdersId(Long loanId);


}
