package sinensia.model;

import java.io.Serializable;

/**lase para los campos de lso usuarios
 * @author Jaime Palomo
 */
public class User implements Serializable{

    private Integer id;
    private String email;
    private String password;
    private String name;
    private int age;

    public User(String email, String password, String name, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    
    /**
     * 
     * 
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of edad
     *
     * @param age new value of edad
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of nombre
     *
     * @param name new value of nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
