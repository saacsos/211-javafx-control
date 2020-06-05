package j07tableview;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

// A class that contains project information.
// We need a class that defines the type of objects that the table will display.
public class ProjectEntity {

    // Declare properties.
    // SimpleStringProperty is one of several classes in javafx.beans.property
    // that encapsulates a value in a property.
    // It implements several interfaces, including Property and Observable.
    // It inherits several classes, including StringPropertyBase.
    private SimpleStringProperty programmer;
    private SimpleStringProperty packageName;
    private SimpleStringProperty status;
    private SimpleIntegerProperty size;

    // Constructor
    public ProjectEntity(String programmer, String packageName, String status, int size) {
        this.programmer = new SimpleStringProperty(programmer);
        this.packageName = new SimpleStringProperty(packageName);
        this.status = new SimpleStringProperty(status);
        this.size = new SimpleIntegerProperty(size);
    }

    // Getters and setters for the properties.
    // An instance of some form of Property is required
    // so that TableView can access its value through the use of get() and set() methods, defined by StringPropertyBase.

    public String getProgrammer() {
        return programmer.get();
    }

    public void setProgrammer(String programmer) {
        this.programmer.set(programmer);
    }

    public String getPackageName() {
        return packageName.get();
    }

    public void setPackageName(String packageName) {
        this.packageName.set(packageName);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        this.size.set(size);
    }
}
