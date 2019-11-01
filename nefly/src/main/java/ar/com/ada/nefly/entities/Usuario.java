package ar.com.ada.nefly.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Usuario
 */
@Document(collection = "Usuarios")
public class Usuario {

    @Id
    private ObjectId _id;

    private String fullName;

    private String userName;
    private String password;
    private String userEmail;

    public Usuario(String fullName, String userName, String password, String userEmail) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }

    public Usuario() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
}