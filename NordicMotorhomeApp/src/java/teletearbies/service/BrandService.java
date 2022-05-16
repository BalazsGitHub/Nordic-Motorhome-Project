package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Brand;
import teletearbies.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public void saveBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand findById(int id) {
        return brandRepository.findById(id).get();
    }

    public List<Brand> getAllBrands() {
        return (List<Brand>) brandRepository.findAll();
    }

}
