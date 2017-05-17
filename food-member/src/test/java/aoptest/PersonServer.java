package aoptest;

/**
 * Created by xiaoliu on 2017/5/17.
 */
public interface PersonServer {

    public void save(String name);
    public void update(String name, Integer id);
    public String getPersonName(Integer id);

}