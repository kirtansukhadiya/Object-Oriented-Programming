//Class 2
//account.java
public class Account {
    private String name; //only accessible in this class aka not global

    public void setName(String name){
        this.name = name; //stores the name
    }

    public String getName(){
        return name; //Returns the value of name of the caller
    }
}

/*
instance variable are the variable which are in each and every object
object_name.method_name - to call the method

*/