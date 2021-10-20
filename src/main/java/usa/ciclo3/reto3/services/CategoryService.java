/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Category;
import usa.ciclo3.reto3.repositories.CategoryRepo;


@Service
public class CategoryService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private CategoryRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Category> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }
    
    public Category save(Category category) {
        if (category.getId()== null) {
            return metodosCrud.save(category);
            
        } else {
            Optional<Category> evt = metodosCrud.getCategory(category.getId());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(category);
                
            } else {
                return category;
                
            }
            
        }
        
    }
    
}


