package com.einvoice.repository;

import com.einvoice.entity.AccountingSupplierParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingSupplierPartyRepository extends JpaRepository<AccountingSupplierParty, Integer> {
}
