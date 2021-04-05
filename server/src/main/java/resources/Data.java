package resources;

public class Data {
    private String nameOfGig;
    private String locationOfGig;
    private String Description;
    private String Salary;
    private String Url;
    //Create getters and setters
    public void setName(String nameOfGig) {
        this.nameOfGig = nameOfGig;
    };
    public String getName() {
        return this.nameOfGig;
    };
    public void setLocation(String locationOfGig) {
        this.locationOfGig = locationOfGig;
    };
    public String getLocation() {
        return this.locationOfGig;
    };
    public void setDescription(String Description) {
        this.Description = Description;
    };
    public String getDescription() {
        return this.Description;
    };
    public void setSalary(String Salary) {
        this.Salary = Salary;
    };
    public String getSalary() {
        return this.Salary;
    };
    public void setUrl(String Url) {
        this.Url = Url;
    };
    public String getUrl() {
        return this.Url;
    };
}