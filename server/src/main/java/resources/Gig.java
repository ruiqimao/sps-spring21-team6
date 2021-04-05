package resources;

public class Gig {
    private String name;
    private String location;
    private String description;
    private String salary;
    private String url;

    public Gig(String name, String location, String description, String salary, String url){
        this.name = name;
        this.location = location;
        this.description = description
        this.salary = salary.isEmpty() ? "N/A" : salary;
        this.url = url;
    }
  
    public String getName() {
        return this.name;
    };

    public String getLocation() {
        return this.location;
    };
 
    public String getDescription() {
        return this.description;
    };
  
    public String getSalary() {
        return this.salary;
    };
 
    public String getUrl() {
        return this.url;
    };
}