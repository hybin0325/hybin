package net.medcrm.yjb.his.web.aggregator.dto;

import java.util.List;

public class DivisionRePosition {
    private String id;
    private String divisionId;
    private String employeeId;
    private String positionId;
    private String positionName;
    private String divisionName;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<EmployeeBasic> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBasic> employees) {
        this.employees = employees;
    }
}
