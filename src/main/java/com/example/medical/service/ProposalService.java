package com.example.medical.service;

import com.example.medical.model.Proposal;
import com.example.medical.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProposalService {

    private final ProposalRepository proposalRepository;

    public List<Proposal> getProposals() {
        return proposalRepository.findAll();
    }

    public void addProposal(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    public void delete(String phone) {
        proposalRepository.deleteByPhone(phone);
    }

    public Proposal findByPhone(String phone) {
        return proposalRepository.findByPhone(phone);
    }
}
