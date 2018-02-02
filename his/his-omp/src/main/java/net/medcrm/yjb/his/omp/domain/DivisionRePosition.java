package net.medcrm.yjb.his.omp.domain;

import java.io.Serializable;
import java.util.List;

public class DivisionRePosition implements Serializable{
    private String id;
    private String divisionId;
    private String divitionName;
    private String employeeId;
    private String positionId;
    private String positionName;
    private List<EmployeeBasic> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getDivitionName() {
        return divitionName;
    }

    public void setDivitionName(String divitionName) {
        this.divitionName = divitionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<EmployeeBasic> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBasic> employees) {
        this.employees = employees;
    }
}
