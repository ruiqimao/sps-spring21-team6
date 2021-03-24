package resources;

public class Data {
    private String NameOfGig;
    private String LocationOfGig;
    private String Description;
    private String Url;
    //Create getters and setters
    public void setName(String NameOfGig){
       this.NameOfGig = NameOfGig;
    };
    public String getName(){
      return NameOfGig;
    };
    public void setLocation(String LocationOfGig){
       this.LocationOfGig = LocationOfGig;
    };
    public String getLocation( String LocationOfGig){
       return LocationOfGig;
    };
    public void setDescription(String Description){
     this.Description = Description;
    };
    public String getDescription(String Description){
      return Description; 
    };
    public void setUrl(String Url){
       this.Url = Url;
    };
    public String getUrl(String Url){
       return Url; 
    };
   
}