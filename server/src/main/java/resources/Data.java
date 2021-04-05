package resources;

public class Data {
    private String nameOfGig;
    private String locationOfGig;
    private String Description;
    private String Url;
    //Create getters and setters
    public void setName(String nameOfGig) {
        this.nameOfGig = nameOfGig;
    };
    public String getName() {
        return nameOfGig;
    };
    public void setLocation(String locationOfGig) {
        this.locationOfGig = locationOfGig;
    };
    public String getLocation(String LocationOfGig) {
        return locationOfGig;
    };
    public void setDescription(String Description) {
        this.Description = Description;
    };
    public String getDescription(String Description) {
        return Description;
    };
    public void setUrl(String Url) {
        this.Url = Url;
    };
    public String getUrl(String Url) {
        return Url;
    };
}