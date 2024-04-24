package mz.org.fgh.mentoring.service.professionalcategory;

import jakarta.inject.Singleton;
import mz.org.fgh.mentoring.dto.professionalCategory.ProfessionalCategoryDTO;
import mz.org.fgh.mentoring.entity.professionalcategory.ProfessionalCategory;
import mz.org.fgh.mentoring.repository.professionalcategory.ProfessionalCategoryRepository;
import mz.org.fgh.mentoring.util.Utilities;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProfessionalCategoryService {

    private final ProfessionalCategoryRepository professionalCategoryRepository;


    public ProfessionalCategoryService(ProfessionalCategoryRepository professionalCategoryRepository) {
        this.professionalCategoryRepository = professionalCategoryRepository;
    }

    public List<ProfessionalCategoryDTO> getAll(Long limit, Long offset) {
        try {
            List<ProfessionalCategory> professionalCategories = new ArrayList<>();
            if(limit!=null && offset!=null && limit>0) {
                professionalCategories = professionalCategoryRepository.findProfessionalCategoriesWithLimit(limit, offset);
            } else {
                professionalCategories = professionalCategoryRepository.findAll();
            }
            return Utilities.parseList(professionalCategories, ProfessionalCategoryDTO.class);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    public ProfessionalCategoryDTO getById(Long id){

        ProfessionalCategory professionalCategory = this.professionalCategoryRepository.findById(id).get();

        return new ProfessionalCategoryDTO(professionalCategory);
    }
}
