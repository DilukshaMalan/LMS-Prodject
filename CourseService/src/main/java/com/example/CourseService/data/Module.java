package com.example.CourseService.data;

import jakarta.persistence.*;

@Entity
@Table(name="module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private String moduleId;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "number_of_hours")
    private int numberOfHours;

    @Column(name = "module_colour")
    private String moduleColour;

    @Column(name = "module_point")
    private int modulePoint;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getModuleColour() {
        return moduleColour;
    }

    public void setModuleColour(String moduleColour) {
        this.moduleColour = moduleColour;
    }

    public int getModulePoint() {
        return modulePoint;
    }

    public void setModulePoint(int modulePoint) {
        this.modulePoint = modulePoint;
    }
}
