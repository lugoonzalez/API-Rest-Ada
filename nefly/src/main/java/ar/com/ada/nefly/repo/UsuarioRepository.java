package ar.com.ada.nefly.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import ar.com.ada.nefly.entities.Usuario;

/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

    Usuario findBy_id(ObjectId _id);    
    Usuario findByUserName(String userName);
    Usuario findByUserEmail(String email);

}