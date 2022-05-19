package com.example.medical.repository;

import com.example.medical.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
    void deleteByPhone(String phone);
    List<Proposal> findAll();
}
