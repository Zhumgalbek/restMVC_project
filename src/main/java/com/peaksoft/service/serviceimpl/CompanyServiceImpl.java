package com.peaksoft.service.serviceimpl;

import com.peaksoft.converter.company.CompanyConverterRequest;
import com.peaksoft.converter.company.CompanyConverterResponse;
import com.peaksoft.dto.request.CompanyRequest;
import com.peaksoft.dto.response.CompanyResponse;
import com.peaksoft.entity.Company;
import com.peaksoft.repository.CompanyRepository;
import com.peaksoft.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyConverterRequest companyConverterRequest;
    private final CompanyConverterResponse companyConverterResponse;

    @Override
    public List<CompanyResponse> getAllCompany() {
        return companyConverterResponse.getAll(companyRepository.findAll());
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = companyRepository.findById(id).get();
        return companyConverterResponse.create(company);
    }

    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        Company company = companyConverterRequest.create(companyRequest);
        companyRepository.save(company);
        return companyConverterResponse.create(company);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).get();
        companyConverterRequest.update(company, companyRequest);
        return companyConverterResponse.create(companyRepository.save(company));
    }

    @Override
    public CompanyResponse deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id).get();
        companyRepository.delete(company);
        return companyConverterResponse.create(company);
    }

}
