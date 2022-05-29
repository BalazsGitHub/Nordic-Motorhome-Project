package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Brand;
import teletearbies.repository.BrandRepository;

import java.util.List;

//the service annotation marks the class as a service provider. It is used on classes that provide functionalities.
@Service
public class BrandService {
    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
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

    public Brand findByName(String name){
        return brandRepository.findBrandByName(name);
    }
}
